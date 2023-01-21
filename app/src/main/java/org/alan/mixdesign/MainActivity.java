package org.alan.mixdesign;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
     Spinner select_marca, uso_aditivo, ensayos_previos, tipo_de_diseño,
     tipo_de_exposicion, asentamiento, especifique_tipo_estructura, consolidacion_vibracion,
     tam_max_agregado, especifique_tipo_expo_concreto, spinner_fuente_agua, spinner_tipo_de_exposicion;

     TextView peso_especifico_cemento, asentamiento_preferencia;

    TextInputEditText m_cliente, m_obra, m_ubicacion;
     TextInputEditText resistencia_del_diseño, desviacion_estandar, numero_de_ensayos, modulo_ag_grueso, peso_sc_agre_gru,humedad_a_f,
       peso_e_a_f, absorcion_ag_grueso, humendad_ag_grueso, absorcion_ag_fino, aditivo, densidad_aditivo, mezcla_necesaria, peso_e_a_g,
    marca_de_aditivo, inputtipo_aditivo, peso_unitario_compactado_a_f, modulo_finura_agregagdo_grueso_v,
             inputapeso_unitario_suelto_agregado_grueso, inputapeso_unitario_suelto_agregado_fino;

     EditText tipo_cemento;
    double d_rel_agua_ceme_durabilidad;
    String m_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-------cemento------------
        tipo_cemento = (EditText)findViewById(R.id.inputtipo_cemento);
        select_marca = (Spinner)findViewById(R.id.spinner_select_marca);
        //---------------------------

        //--------Aditivo--------
        marca_de_aditivo= (TextInputEditText)findViewById(R.id.inputmarca_aditivo);
        inputtipo_aditivo = (TextInputEditText)findViewById((R.id.inputtipo_aditivo));

        uso_aditivo = (Spinner)findViewById(R.id.spinner_uso_aditivo);
        tipo_de_diseño = (Spinner)findViewById(R.id.spinner_tipo_de_diseño);
        asentamiento =(Spinner)findViewById(R.id.spinner_asentamiento);
        especifique_tipo_estructura = (Spinner)findViewById(R.id.spinner_tipo_de_estructura);
        consolidacion_vibracion = (Spinner)findViewById(R.id.spinner_consolidacion_por_vibracion);
        tam_max_agregado = (Spinner)findViewById(R.id.spinner_tamaño_max_del_agregado);
        tipo_de_exposicion = (Spinner)findViewById(R.id.spinner_tipo_de_exposicion);
        especifique_tipo_expo_concreto =(Spinner)findViewById(R.id.spinner_tipo_de_exposicion_especifique);
        spinner_fuente_agua = (Spinner)findViewById(R.id.spinner_agua) ;

        spinner_tipo_de_exposicion = (Spinner)findViewById(R.id.spinner_tipo_de_exposicion);

        peso_especifico_cemento = (TextInputEditText)findViewById(R.id.inputpeso_especifico_cemento);
        asentamiento_preferencia = (TextView)findViewById(R.id.viewasentamiento_de_preferencia);

        resistencia_del_diseño =(TextInputEditText)findViewById(R.id.inputresistencia_del_diseño);
        desviacion_estandar =(TextInputEditText)findViewById(R.id.inpudesviacion_estandar);
        numero_de_ensayos = (TextInputEditText)findViewById(R.id.inputnumerode_ensayos);
        modulo_ag_grueso = (TextInputEditText)findViewById(R.id.inputmodulo_finura_a_f);
        peso_unitario_compactado_a_f =  (TextInputEditText)findViewById(R.id.inputpe_unitario_compactado);
        peso_sc_agre_gru= (TextInputEditText)findViewById(R.id.inputpe_unitario_compactado_agregado_grueso);
        peso_e_a_f = (TextInputEditText)findViewById(R.id.inputpeso_especifico_a_f);
        humedad_a_f = (TextInputEditText)findViewById(R.id.inputhumedad_natural_a_F);
        absorcion_ag_grueso =  (TextInputEditText)findViewById(R.id.inputpabsorcion_agregado_grueso);
        humendad_ag_grueso = (TextInputEditText)findViewById(R.id.inputhumedad_natural_agregado_grueso);
        absorcion_ag_fino =(TextInputEditText)findViewById(R.id.inputabsorcion_ag_fino);

        aditivo = (TextInputEditText) findViewById(R.id.inputdosis_aditivo);

        densidad_aditivo = (TextInputEditText)findViewById(R.id.inputdensidad_aditivo);

        mezcla_necesaria = (TextInputEditText)findViewById(R.id.inputmezcla_necesaria);
        peso_e_a_g = (TextInputEditText)findViewById(R.id.inputpeso_especifico_agregado_grueso);

        modulo_finura_agregagdo_grueso_v = (TextInputEditText)findViewById(R.id. inputmodulo_finura_agregagdo_grueso);

        inputapeso_unitario_suelto_agregado_fino = (TextInputEditText)findViewById(R.id.inputapeso_unitario_suelto_agregado_fino);

        inputapeso_unitario_suelto_agregado_grueso  = (TextInputEditText)findViewById(R.id.inputapeso_unitario_suelto_agregado_grueso);

       m_cliente = (TextInputEditText) findViewById(R.id.input_cliente);
        m_obra = (TextInputEditText) findViewById(R.id.input_obra);
        m_ubicacion = (TextInputEditText) findViewById(R.id.input_ubicacion);

        String [] opciones_marca = {"Andino","Sol","Lima","Pacasmayo","Yura", "Selva", "Quisqueya", "Sur"};
        ArrayAdapter <String> adaptder1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,  opciones_marca);
        select_marca.setAdapter(adaptder1);
        select_marca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                String seleccion_opciones_marca = select_marca.getSelectedItem().toString();

                if (seleccion_opciones_marca.equals("Andino") || seleccion_opciones_marca.equals("Selva") || seleccion_opciones_marca.equals("Quisqueya") ){
                    int valor = 3150;
                    String valorfinal = String.valueOf(valor);
                    peso_especifico_cemento.setText(valorfinal); }
                else if (seleccion_opciones_marca.equals("Sol") || seleccion_opciones_marca.equals("Lima")){
                    int valor = 3110;
                    String valorfinal = String.valueOf(valor);
                    peso_especifico_cemento.setText(valorfinal);}
                else if (seleccion_opciones_marca.equals("Pacasmayo")){
                    int valor = 3120;
                    String valorfinal = String.valueOf(valor);
                    peso_especifico_cemento.setText(valorfinal);}
                else if (seleccion_opciones_marca.equals("Yura")){
                    int valor = 3090;
                    String valorfinal = String.valueOf(valor);
                    peso_especifico_cemento.setText(valorfinal);}
                else if (seleccion_opciones_marca.equals("Sur")){
                    int valor = 3100;
                    String valorfinal = String.valueOf(valor);
                    peso_especifico_cemento.setText(valorfinal);}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String [] select_aditivo = {"Si","No"};
        final ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, select_aditivo);
        uso_aditivo.setAdapter(adapter);
        uso_aditivo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                String seleccion_aditivo = uso_aditivo.getSelectedItem().toString();
                if (seleccion_aditivo.equals("No")){

                   alerta_aditivo();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String [] select_t_diseño= { "Con aire", "Sin aire"};
        ArrayAdapter <String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, select_t_diseño);
        tipo_de_diseño.setAdapter(adapter3);
        tipo_de_diseño.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final String [] select_fuente = {"Potable", "No Potable"};
        ArrayAdapter <String> adapter101= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, select_fuente);
        spinner_fuente_agua.setAdapter(adapter101);
        spinner_fuente_agua.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
          ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
      });

        final String [] select_asentamiento = {"Seco", "Plastico", "Fluido", "No se tiene" };
        ArrayAdapter <String> adapter5 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, select_asentamiento);
        asentamiento.setAdapter(adapter5);
        asentamiento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final String [] select_tipo_estructura = {"Zapatas y muros de cimentacion armados", "Cimentaciones simples, Cajones, subestructuras de muros",
                "Vigas y muros armados", "Columnas de edificios", "Losas y pavimentos", "Concreto ciclopeo", "No es necesario"};
        ArrayAdapter <String> adapter6 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, select_tipo_estructura);
        especifique_tipo_estructura.setAdapter(adapter6);
        especifique_tipo_estructura.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccion_opciones_marca = especifique_tipo_estructura.getSelectedItem().toString();
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);

                if (seleccion_opciones_marca.equals("Zapatas y muros de cimentacion armados") ||
                        seleccion_opciones_marca.equals( "Cimentaciones simples, Cajones, subestructuras de muros")
                        || seleccion_opciones_marca.equals("Losas y pavimentos") ){
                    int valor1 = 1;
                    int valor2 =  3;
                    String valorfinal1 = String.valueOf(valor1);
                    String valorfinal2 = String.valueOf(valor2);
                    asentamiento_preferencia.setText(" De "+valorfinal1 + " '' a   " +valorfinal2 + " ''"); }
                else if (seleccion_opciones_marca.equals("Vigas y muros armados") ||
                        seleccion_opciones_marca.equals( "Columnas de edificios") ){
                    int valor1 = 1;
                    int valor2 =  4;
                    String valorfinal1 = String.valueOf(valor1);
                    String valorfinal2 = String.valueOf(valor2);
                    asentamiento_preferencia.setText(" De "+valorfinal1 + " '' a   " +valorfinal2 + " ''"); }
                else if (seleccion_opciones_marca.equals("Concreto ciclopeo")){
                    int valor1 = 1;
                    int valor2 =  2;
                    String valorfinal1 = String.valueOf(valor1);
                    String valorfinal2 = String.valueOf(valor2);
                    asentamiento_preferencia.setText(" De "+valorfinal1 + " '' a   " +valorfinal2 + " ''"); }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        String [] select_consolidacion_vibracion = {"Si", "No"};
        ArrayAdapter <String> adapter8 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, select_consolidacion_vibracion);
        consolidacion_vibracion.setAdapter(adapter8);
        consolidacion_vibracion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String [] select_tamano_max_agregado = {"3/8''"," 1/2''", "3/4''","1''","1 1/2''","2''","3''","6''"};
        ArrayAdapter <String> adapter9 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,  select_tamano_max_agregado);
        tam_max_agregado.setAdapter(adapter9);
        tam_max_agregado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String [] select_tipo_de_exposicion = {"Baja permeabilidad", "Exposición al ataque de sulfatos", "Proceso de congelamiento de deshielo"
                , "Proceso contra la corrosión del concreto","Ninguno"};
        ArrayAdapter <String> adapter10 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, select_tipo_de_exposicion);
        tipo_de_exposicion.setAdapter(adapter10);

        tipo_de_exposicion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                String seleccion = tipo_de_exposicion.getSelectedItem().toString();
                if (seleccion.equals("Baja permeabilidad")) {

                    especifique_baja_permeabilidad();
                }
                if (seleccion.equals("Exposición al ataque de sulfatos")) {
                    especifique_exposición_al_ataque_de_sulfatos();
                }
                if (seleccion.equals("Proceso de congelamiento de deshielo")) {
                    especifique_proceso_de_congelamiento_de_deshielo();
                }
                if (seleccion.equals("Proceso contra la corrosión del concreto")) {
                    especifique_proceso_contra_la_corrosión_del_concreto();
                }
                if (seleccion.equals("Ninguno")) {
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void especifique_baja_permeabilidad(){
        String[] opciones_2 = {"Expuesto a agua dulce", "Expuesto a agua de mar o aguas solubles", "Expuesto a la acción de aguas cloacales"};
        ArrayAdapter<String> adaptader = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones_2);
        especifique_tipo_expo_concreto.setAdapter(adaptader);
        especifique_tipo_expo_concreto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void especifique_exposición_al_ataque_de_sulfatos(){
        String[] opciones_2 = {"Despreciable", "Moderada", "Severa", "Muy servera"};
        ArrayAdapter<String> adaptader = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones_2);
        especifique_tipo_expo_concreto.setAdapter(adaptader);
    }
    public void especifique_proceso_de_congelamiento_de_deshielo(){
        String[] opciones_2 = {"Suave", "Moderada", "Severa"};
        ArrayAdapter<String> adaptader = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones_2);
        especifique_tipo_expo_concreto.setAdapter(adaptader);
    }
    public void especifique_proceso_contra_la_corrosión_del_concreto(){
        String[] opciones_2 = {"Recubrimiento mínimo incrementado a 15mm", "Recubrimiento mínimo no incrementado a 15mm", "Severa"};
        ArrayAdapter<String> adaptader = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones_2);
        especifique_tipo_expo_concreto.setAdapter(adaptader);
    }

    public void alerta_tipo_expo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.CustomDialogTheme);
        builder.setTitle("Alerta");
        builder.setMessage("La resistencia del diseño es muy bajo para el tipo de exposición, tiene que ser mayor a 260")
                .setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(false).show();

    }

    public void alerta_tipo_expo_2(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.CustomDialogTheme);
        builder.setTitle("Alerta");
        builder.setMessage("La resistencia del diseño es muy bajo para el tipo de exposición, tiene que ser mayor a 280")
                .setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(false).show();

    }

    public void alerta_tipo_expo_3(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.CustomDialogTheme);
        builder.setTitle("Alerta");
        builder.setMessage("La resistencia del diseño es muy bajo para el tipo de exposición, tiene que ser mayor a 300")
                .setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(false).show();

    }
    public void alerta_tipo_expo_4(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.CustomDialogTheme);
        builder.setTitle("Alerta");
        builder.setMessage("La resistencia del diseño es muy bajo para el tipo de exposición, tiene que ser mayor a 325")
                .setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(false).show();

    }

    public void alerta_tipo_expo_5(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.CustomDialogTheme);
        builder.setTitle("Alerta");
        builder.setMessage("La resistencia del diseño es muy bajo para el tipo de exposición, tiene que ser mayor a 175")
                .setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(false).show();

    }
    public void alerta_dato_vacio(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.CustomDialogTheme);
        builder.setTitle("Alerta");
        builder.setMessage("Por favor compruebe que este rellenado todos los datos que son" +
                " fundamentales para el correcto cálculo")
                .setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(false).show();

    }

    public void alerta_aditivo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.CustomDialogTheme);
        builder.setTitle("Aviso");
        builder.setMessage("Ya que el diseño de mezcla no lleva aditivo, por favor rellene los campos" +
                " de dosis y densidad con el valor de cero, para el correcto funcionamiento de la aplicación.")
                .setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(false).show();
    }

    public void proceso_dosificacion (View view) {
        Intent  ir = new Intent(this, MainActivity2.class);
        double gravedad = 9.81;
        if ( "".equals(resistencia_del_diseño) || "".equals(desviacion_estandar)
                || numero_de_ensayos.getText().toString().isEmpty() || modulo_ag_grueso.getText().toString().isEmpty()
                || peso_sc_agre_gru.getText().toString().isEmpty() || humedad_a_f.getText().toString().isEmpty()
                ||peso_e_a_f.getText().toString().isEmpty()||  absorcion_ag_grueso.getText().toString().isEmpty()
                || humendad_ag_grueso.getText().toString().isEmpty() || absorcion_ag_fino.getText().toString().isEmpty()
                || densidad_aditivo.getText().toString().isEmpty()|| mezcla_necesaria.getText().toString().isEmpty()
                || peso_e_a_g.getText().toString().isEmpty() || desviacion_estandar.getText().toString().isEmpty()
                || inputapeso_unitario_suelto_agregado_grueso.getText().toString().isEmpty()
                || inputapeso_unitario_suelto_agregado_fino.getText().toString().isEmpty()
                || tipo_cemento.getText().toString().isEmpty()
                || marca_de_aditivo.getText().toString().isEmpty()
                || inputtipo_aditivo.getText().toString().isEmpty()

        ){
                    alerta_dato_vacio();
        }else{

            //---------cemento
            String tipo_de_cemento = tipo_cemento.getText().toString();
            String marca_de_cemento = select_marca.getSelectedItem().toString();
            //----------------------------------------

            //----------Aditivo-----------
            String text_marca_de_aditivo = marca_de_aditivo.getText().toString();
            String tipo_de_aditivo = inputtipo_aditivo.getText().toString();

            //------------agua-----------
            String tipo_de_agua = spinner_fuente_agua.getSelectedItem().toString();

            //---------------peso unitario suelto

             String p_u_s_a_g = inputapeso_unitario_suelto_agregado_grueso.getText().toString();
             String p_u_s_a_f = inputapeso_unitario_suelto_agregado_fino.getText().toString();

                String str_des_est = desviacion_estandar.getText().toString();
                double d_des_est = Double.parseDouble(str_des_est);

                String str_n_ensayos = numero_de_ensayos.getText().toString();
                double i_num_ensayos =Double.parseDouble(str_n_ensayos);

                String str_resis_dis = resistencia_del_diseño.getText().toString();
                double d_resis_dis = Double.parseDouble(str_resis_dis);

                String TMN = tam_max_agregado.getSelectedItem().toString();
                String asentamiento_val = asentamiento.getSelectedItem().toString();

                String aire = tipo_de_diseño.getSelectedItem().toString();

                String tipo_expo= spinner_tipo_de_exposicion.getSelectedItem().toString();

                String str_modulo_ag_grueso = modulo_ag_grueso.getText().toString();
                double d_modulo_ag_grueso = Double.parseDouble(str_modulo_ag_grueso);

                String str_peso_sc_agre_gru = peso_sc_agre_gru.getText().toString();


                String Especificacion = especifique_tipo_expo_concreto.getSelectedItem().toString();

                String seleccion_expo = tipo_de_exposicion.getSelectedItem().toString();

            String peso_u_c_a_f = peso_unitario_compactado_a_f.getText().toString();



                String s_p_e_a_f = peso_e_a_f.getText().toString();
                double p_e_a_f = Double.parseDouble(s_p_e_a_f);

                String s_h_a_f = humedad_a_f.getText().toString();
                double h_a_f = Double.parseDouble(s_h_a_f);

                String s_h_a_g = humendad_ag_grueso.getText().toString();
                double h_a_g = Double.parseDouble(s_h_a_g);

                String s_ab_a_g = absorcion_ag_grueso.getText().toString();
                double ab_a_g = Double.parseDouble(s_ab_a_g);

                String s_ab_a_f = absorcion_ag_fino.getText().toString();
                double ab_a_f = Double.parseDouble(s_ab_a_f);

                String aditivoxbls = aditivo.getText().toString();
                double d_aditivoxbls = Double.parseDouble(aditivoxbls);

                String s_densidad_adi = densidad_aditivo.getText().toString();
                double d_densidad_adi = Double.parseDouble(s_densidad_adi);

                double p_e_aditivo = d_densidad_adi*gravedad;

                String s_mezcla_necesaria = mezcla_necesaria.getText().toString();
                double d_mezcla_necesaria = Double.parseDouble(s_mezcla_necesaria);

                String s_peso_e_a_g = peso_e_a_g.getText().toString();
                double d_peso_e_a_g = Double.parseDouble(s_peso_e_a_g);

                String s_p_c = peso_especifico_cemento.getText().toString();
                double d_p_c = Double.parseDouble(s_p_c);

                 String m_d_f_a_g =   modulo_finura_agregagdo_grueso_v.getText().toString();
                double m_d_f_a_g_d =   Double.parseDouble(m_d_f_a_g);

                String cliente  = m_cliente.getText().toString();
                String obra = m_obra.getText().toString();
                String ubicacion= m_ubicacion.getText().toString();


            if ("Baja permeabilidad".equals(seleccion_expo) && d_resis_dis<260) {
                   alerta_tipo_expo();
                }
                else if ("Exposición al ataque de sulfatos".equals(seleccion_expo) && d_resis_dis<280) {
                    alerta_tipo_expo_2();
                }
                else if ("Proceso de congelamiento de deshielo".equals(seleccion_expo) && d_resis_dis<300) {
                    alerta_tipo_expo_3();
                }
                else if ("Proceso contra la corrosión del concreto".equals(seleccion_expo) && d_resis_dis<325) {
                    alerta_tipo_expo_4();
                }else if("Niguno".equals(seleccion_expo)&& d_resis_dis<175)
                    alerta_tipo_expo_5();
               else   {

                if ("Baja permeabilidad".equals(seleccion_expo)|| "Exposición al ataque de sulfatos".equals(seleccion_expo)||
                        "Proceso de congelamiento de deshielo".equals(seleccion_expo) ){
                            Double a_c= 0.45;

                            ir.putExtra("valor_ac",a_c);
                }
                if ("Proceso contra la corrosión del concreto".equals(seleccion_expo) ){
                            Double a_c= 0.40;
                            ir.putExtra("valor_ac",a_c);
                }if ("Ninguno".equals(seleccion_expo)){
                        Double a_c= 0.40;
                        ir.putExtra("valor_ac",a_c);
                    }

                ir.putExtra("desviacion estandar",d_des_est);
                ir.putExtra("nº de ensayos", i_num_ensayos);
                ir.putExtra("resis diseño", d_resis_dis);
                ir.putExtra("TMN",TMN);
                ir.putExtra("asentamiento", asentamiento_val);
                ir.putExtra("selec_aire", aire);
                ir.putExtra("tipo_expo", tipo_expo);
                ir.putExtra("modulo_ag_grueso", m_d_f_a_g_d);
                ir.putExtra("peso_sc_agre_grueso",str_peso_sc_agre_gru);
                ir.putExtra("d_peso_sc_agre_grueso",str_peso_sc_agre_gru);
                ir.putExtra("espe_tipo_espo",Especificacion);
                ir.putExtra("p_e_a_f",p_e_a_f);
                ir.putExtra("h_a_f",h_a_f);
                ir.putExtra("h_a_g",h_a_g);
                ir.putExtra("ab_a_g", ab_a_g);
                ir.putExtra("ab_a_f", ab_a_f);
                ir.putExtra("aditivoxbls", d_aditivoxbls);
                ir.putExtra("p_e_aditivo", p_e_aditivo);
                ir.putExtra("mezcla_necesaria", d_mezcla_necesaria);
                ir.putExtra("d_peso_e_a_g",d_peso_e_a_g);
                ir.putExtra("d_p_c", d_p_c);
                ir.putExtra("tipo_de_cemento", tipo_de_cemento);
                ir.putExtra("marca_de_cemento", marca_de_cemento);
                ir.putExtra("marca_de_aditivo",text_marca_de_aditivo);
                ir.putExtra("tipo_de_aditivo",tipo_de_aditivo);
                ir.putExtra("tipo_de_agua",tipo_de_agua);
                ir.putExtra("p_u_c_a_f",peso_u_c_a_f);
                ir.putExtra("m_d_f_a_g",m_d_f_a_g);
                ir.putExtra("p_u_s_a_g",p_u_s_a_g);
                ir.putExtra("p_u_s_a_f",p_u_s_a_f);
                ir.putExtra("cliente",cliente);
                ir.putExtra("obra",obra);
                ir.putExtra("ubicacion",ubicacion);

                startActivity(ir);
                overridePendingTransition(R.anim.zoom_in, R.anim.static_animation);
        }
            }
    }

     public void ir_a_informe (View view) {
         Intent ir_a_informe = new Intent(this, informe.class);
         startActivity(ir_a_informe);
         overridePendingTransition(R.anim.zoom_in, R.anim.static_animation);
     }

        public boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.menu_barra_superior, menu);
            return true;
        }
        public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.informacion_item) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.CustomDialogTheme);
            builder.setTitle("Información");
            builder.setMessage("Bienvenido! a continuación te muestro los pasos  para el correcto funcionamiento de la app: \n" +
                    "1. Se completa los datos requeridos de los materiales: \n\n" +
                    "  -  Cemento.\n" +
                    "  -  Agregado grueso.\n" +
                    "  -  Agregado fino .\n" +
                    "  -  Aditivo.\n\n" +
                    "2. Se completa las características del concreto deseado.\n\n" +
                    "3. Puedes acceder al proceso de dosificación obtenida por el método del comité ACI 211 una vez " +
                    "rellenado todos los datos correctamente presionando el botón " +
                    "Ir al proceso de dosificación.\n\n" +
                    "4. Puedes ver las tablas de diseño dando click en el ícono de tablas en la parte superior de esta ventana.\n\n"+
                    "5. En el proceso de dosificación podrás exportar los resultados a un formato PDF" +
                    " el cual se guardará en la memoria interna de tu celular en la ubicación: \n\n\t  Diseño demezcla/Diseño_de_mezcla.pdf" )
                    .setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setCancelable(false).show();
            }
        if (id == R.id.tabla_item)
        {
            Intent ir_a_tablas_de_diseno =new Intent(this, tables_design.class);
            startActivity(ir_a_tablas_de_diseno);
            overridePendingTransition(R.anim.zoom_out, R.anim.static_animation);
        }
            return super.onOptionsItemSelected(item);
        }
}