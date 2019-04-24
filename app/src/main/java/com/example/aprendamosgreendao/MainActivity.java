package com.example.aprendamosgreendao;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aprendamosgreendao.adapters.adapterUsers;
import com.example.aprendamosgreendao.models.User;
import com.example.aprendamosgreendao.models.UserDao;
import com.example.aprendamosgreendao.models.db.DaoHelper;

import org.greenrobot.greendao.query.Query;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private UserDao userDao;
    private Query<User> queryUser;
    private adapterUsers mAdapter;
    private DaoHelper daoHelper;

    private EditText editTextUser;
    private EditText editTextName;
    private EditText editTextFirtsName;
    private EditText editTextLastName;
    private EditText editTextEmail;
    private EditText editTextAge;

    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crea la base de datos
        creaBaseDeDatos();

        initView();

        userDao = daoHelper.getDaoSession().getUserDao();

        //Contien la lista de usuarios de las base de datos
        queryUser = userDao.queryBuilder().orderAsc(UserDao.Properties.User).build();

        //Carga en el recycler view los usuarios
        loadUsers();

    }

    private void creaBaseDeDatos(){
        try{

            daoHelper = DaoHelper.getSingleton();
            daoHelper.init(MainActivity.this, "acodigo_db");

        }catch (Exception e){
            Log.d("Error en: ", e.getMessage());
        }
    }

    private void initView(){
        editTextUser = findViewById(R.id.et_user);
        editTextName = findViewById(R.id.et_name);
        editTextFirtsName = findViewById(R.id.et_firtsname);
        editTextLastName = findViewById(R.id.et_lastname);
        editTextEmail = findViewById(R.id.et_email);
        editTextAge = findViewById(R.id.et_age);
        buttonRegister = findViewById(R.id.btn_register_user);


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }

    private void addUser(){

        //Contiene los elementos de las vistas
        String user = editTextUser.getText().toString();
        String name = editTextName.getText().toString();
        String firtsName = editTextFirtsName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String email = editTextEmail.getText().toString();
        int age = Integer.parseInt(editTextAge.getText().toString());


        //Contiene la sesion de la clase user
        userDao = daoHelper.getDaoSession().getUserDao();

        //Instancia la lase User
        User modelUser = new User();

        modelUser.setUser(user);
        modelUser.setName(name);
        modelUser.setFirtsName(firtsName);
        modelUser.setLastName(lastName);
        modelUser.setEmail(email);
        modelUser.setAge(age);

        //Guaramos el registros
        userDao.save(modelUser);

        //Carla la lista de Usuarios
        loadUsers();
    }


    private void loadUsers(){

        List<User> listUsers = queryUser.list();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_users);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new adapterUsers(listUsers, MainActivity.this);
        recyclerView.setAdapter(mAdapter);

    }



}
