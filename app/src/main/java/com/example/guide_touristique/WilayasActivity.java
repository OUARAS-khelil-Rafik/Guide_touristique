package com.example.guide_touristique;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class WilayasActivity extends AppCompatActivity {

    private GridView gridWilayas;
    private EditText searchBar;
    private WilayaAdapter wilayaAdapter;
    private List<Wilaya> allWilayas, filteredWilayas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilayas);

        // Initialisation des vues
        gridWilayas = findViewById(R.id.gridWilayas);
        searchBar = findViewById(R.id.searchBar);
        ImageButton btnHome = findViewById(R.id.btnHome);

        // Initialisation des données
        allWilayas = getWilayasList();
        filteredWilayas = new ArrayList<>(allWilayas);

        // Initialisation de l'adaptateur
        wilayaAdapter = new WilayaAdapter(this, filteredWilayas);
        gridWilayas.setAdapter(wilayaAdapter);

        // Écouteur de clic sur le bouton Home
        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(WilayasActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        // Écouteur de recherche
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterWilayas(s.toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Écouteur de clic sur un élément de la grille
        gridWilayas.setOnItemClickListener((parent, view, position, id) -> {
            Wilaya selectedWilaya = filteredWilayas.get(position);
            Intent intent = new Intent(WilayasActivity.this, WilayaDetailsActivity.class);
            intent.putExtra("WILAYA_NAME", selectedWilaya.getName());
            startActivity(intent);
        });
    }

    // Filtrer les wilayas en fonction de la recherche
    private void filterWilayas(String query) {
        filteredWilayas.clear();
        if (query.isEmpty()) {
            filteredWilayas.addAll(allWilayas);
        } else {
            String regex = ".*" + Pattern.quote(query.toLowerCase(Locale.ROOT)) + ".*";
            for (Wilaya wilaya : allWilayas) {
                if (Pattern.matches(regex, wilaya.getName().toLowerCase(Locale.ROOT)) ||
                        Pattern.matches(regex, wilaya.getArabicName().toLowerCase(Locale.ROOT))) {
                    filteredWilayas.add(wilaya);
                }
            }
        }
        wilayaAdapter.notifyDataSetChanged();
    }

    // Liste des 58 wilayas en anglais et en arabe
    private List<Wilaya> getWilayasList() {
        List<Wilaya> wilayas = new ArrayList<>();
        wilayas.add(new Wilaya("Adrar", "أدرار"));
        wilayas.add(new Wilaya("Chlef", "الشلف"));
        wilayas.add(new Wilaya("Laghouat", "الأغواط"));
        wilayas.add(new Wilaya("Oum El Bouaghi", "أم البواقي"));
        wilayas.add(new Wilaya("Batna", "باتنة"));
        wilayas.add(new Wilaya("Bejaia", "بجاية"));
        wilayas.add(new Wilaya("Biskra", "بسكرة"));
        wilayas.add(new Wilaya("Bechar", "بشار"));
        wilayas.add(new Wilaya("Blida", "البليدة"));
        wilayas.add(new Wilaya("Bouira", "البويرة"));
        wilayas.add(new Wilaya("Tamanrasset", "تمنراست"));
        wilayas.add(new Wilaya("Tebessa", "تبسة"));
        wilayas.add(new Wilaya("Tlemcen", "تلمسان"));
        wilayas.add(new Wilaya("Tiaret", "تيارت"));
        wilayas.add(new Wilaya("Tizi Ouzou", "تيزي وزو"));
        wilayas.add(new Wilaya("Algiers", "الجزائر"));
        wilayas.add(new Wilaya("Djelfa", "الجلفة"));
        wilayas.add(new Wilaya("Jijel", "جيجل"));
        wilayas.add(new Wilaya("Setif", "سطيف"));
        wilayas.add(new Wilaya("Saida", "سعيدة"));
        wilayas.add(new Wilaya("Skikda", "سكيكدة"));
        wilayas.add(new Wilaya("Sidi Bel Abbes", "سيدي بلعباس"));
        wilayas.add(new Wilaya("Annaba", "عنابة"));
        wilayas.add(new Wilaya("Guelma", "قالمة"));
        wilayas.add(new Wilaya("Constantine", "قسنطينة"));
        wilayas.add(new Wilaya("Medea", "المدية"));
        wilayas.add(new Wilaya("Mostaganem", "مستغانم"));
        wilayas.add(new Wilaya("Msila", "المسيلة"));
        wilayas.add(new Wilaya("Mascara", "معسكر"));
        wilayas.add(new Wilaya("Ouargla", "ورقلة"));
        wilayas.add(new Wilaya("Oran", "وهران"));
        wilayas.add(new Wilaya("El Bayadh", "البيض"));
        wilayas.add(new Wilaya("Illizi", "إليزي"));
        wilayas.add(new Wilaya("Bordj Bou Arreridj", "برج بوعريريج"));
        wilayas.add(new Wilaya("Boumerdes", "بومرداس"));
        wilayas.add(new Wilaya("El Tarf", "الطارف"));
        wilayas.add(new Wilaya("Tindouf", "تندوف"));
        wilayas.add(new Wilaya("Tissemsilt", "تيسمسيلت"));
        wilayas.add(new Wilaya("El Oued", "الوادي"));
        wilayas.add(new Wilaya("Khenchela", "خنشلة"));
        wilayas.add(new Wilaya("Souk Ahras", "سوق أهراس"));
        wilayas.add(new Wilaya("Tipaza", "تيبازة"));
        wilayas.add(new Wilaya("Mila", "ميلة"));
        wilayas.add(new Wilaya("Ain Defla", "عين الدفلى"));
        wilayas.add(new Wilaya("Naama", "النعامة"));
        wilayas.add(new Wilaya("Ain Temouchent", "عين تموشنت"));
        wilayas.add(new Wilaya("Ghardaia", "غرداية"));
        wilayas.add(new Wilaya("Relizane", "غليزان"));
        wilayas.add(new Wilaya("Timimoun", "تيميمون"));
        wilayas.add(new Wilaya("Bordj Badji Mokhtar", "برج باجي مختار"));
        wilayas.add(new Wilaya("Ouled Djellal", "أولاد جلال"));
        wilayas.add(new Wilaya("Beni Abbes", "بني عباس"));
        wilayas.add(new Wilaya("In Salah", "عين صالح"));
        wilayas.add(new Wilaya("In Guezzam", "عين قزام"));
        wilayas.add(new Wilaya("Touggourt", "تقرت"));
        wilayas.add(new Wilaya("Djanet", "جانت"));
        wilayas.add(new Wilaya("El M'Ghair", "المغير"));
        wilayas.add(new Wilaya("El Menia", "المنيعة"));

        return wilayas;
    }
}