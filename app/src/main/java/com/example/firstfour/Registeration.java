package com.example.firstfour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class Registeration extends AppCompatActivity {

    EditText username,email,pass,confirm_pass;
    Button validate_register;
    ImageView upload_image;
    String username_get,email_get,pass_get,confirm_pass_get,userid;
    String img_url="null";
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri mImageUri;
    FirebaseFirestore firestore;
    FirebaseAuth fAuth;
    StorageReference storageReference;
    ProgressBar preogressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        username=(EditText)findViewById(R.id.inputUsername);
        email=(EditText)findViewById(R.id.inputEmail_register);
        pass=(EditText)findViewById(R.id.inputPassword);
        confirm_pass=(EditText)findViewById(R.id.inputConformPassword);
        upload_image=(ImageView)findViewById(R.id.image_insert);
        preogressbar=(ProgressBar)findViewById(R.id.login_progress);

        upload_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
            }
        });

        preogressbar.setVisibility(View.INVISIBLE);

        validate_register=(Button)findViewById(R.id.btnRegister);


        fAuth= FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();

        fAuth.signOut();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        validate_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username_get=username.getText().toString();
                email_get=email.getText().toString();
                pass_get=pass.getText().toString();
                confirm_pass_get=confirm_pass.getText().toString();

                if(TextUtils.isEmpty(username_get)){
                    username.setError("Name is Required.");
                    return;
                }

                if(TextUtils.isEmpty(email_get)){
                    email.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(pass_get)){
                    pass.setError("Password is Required.");
                    return;
                }

                if(pass_get.length() < 6){
                    pass.setError("Password Must be >= 6 Characters");
                    return;
                }

                if(TextUtils.isEmpty(confirm_pass_get)){
                    pass.setError("Confirm Password is Required.");
                    return;
                }
                if(!pass_get.equals(confirm_pass_get)){
                    pass.setError("Password is not matching.");
                    return;
                }

                if(mImageUri==null){
                    Toast.makeText(Registeration.this, "PLS UPLOAD AN IMAGE", Toast.LENGTH_SHORT).show();
                }

                preogressbar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email_get,confirm_pass_get).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            userid=fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference=firestore.collection("users").document(userid);
                            Map<String,Object> user= new HashMap<>();
                            user.put("Name",username_get);
                            user.put("Email",email_get);
                            user.put("Password",confirm_pass_get);
                            user.put("imageUrl",img_url);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Registeration.this, "Successful", Toast.LENGTH_SHORT).show();

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Registeration.this, "Failed", Toast.LENGTH_SHORT).show();
                                }
                            });
                            startstorageprocessimage();

                        }
                        else{
                            //  Toast.makeText(Registeration.this, "Error ", Toast.LENGTH_SHORT).show();
                        }


                    }
                });



            }
        });

        TextView btn=findViewById(R.id.alreadyHaveAccount);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registeration.this,Login.class));
            }
        });
    }

    private void startstorageprocessimage() {
        if(mImageUri==null){
            Toast.makeText(Registeration.this, "PLS UPLOAD AN IMAGE", Toast.LENGTH_SHORT).show();
        }

        final StorageReference reference=storageReference.child("image_files/"+System.currentTimeMillis()+".jpeg");
        reference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        DocumentReference documentReference = FirebaseFirestore.getInstance().collection("users").document(fAuth.getCurrentUser().getUid());
                        Map<String,Object> user= new HashMap<>();
                        user.put("imageUrl",uri.toString());
                        documentReference.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Registeration.this, "Photo Updated", Toast.LENGTH_SHORT).show();
                                preogressbar.setVisibility(View.INVISIBLE);
                                Toast.makeText(Registeration.this, "Data Updated, Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Login.class));
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Registeration.this, "Photo Updatation Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

            }
        });
    }

    private void openFileChooser() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri = data.getData();
            Picasso.Builder builder = new Picasso.Builder(this);
            builder.listener(new Picasso.Listener()
            {
                @Override
                public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception)
                {
                    exception.printStackTrace();
                }
            });
            builder.build().load(mImageUri).into(upload_image);
        }
    }
}