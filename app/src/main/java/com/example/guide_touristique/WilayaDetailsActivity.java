package com.example.guide_touristique;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;


import java.util.HashMap;
import java.util.Map;

public class WilayaDetailsActivity extends AppCompatActivity {

    private TextView wilayaTitle;

    private ScrollView scrollView;

    // Références aux sections
    private TextView descriptionSection, sitesSection, dormirSection, mangerSection;

    // Dictionnaire des wilayas (Anglais -> Arabe)
    private static final Map<String, String> wilayaMap = new HashMap<>();
    static {
        wilayaMap.put("Adrar", "أدرار");
        wilayaMap.put("Chlef", "الشلف");
        wilayaMap.put("Laghouat", "الأغواط");
        wilayaMap.put("Oum El Bouaghi", "أم البواقي");
        wilayaMap.put("Batna", "باتنة");
        wilayaMap.put("Bejaia", "بجاية");
        wilayaMap.put("Biskra", "بسكرة");
        wilayaMap.put("Bechar", "بشار");
        wilayaMap.put("Blida", "البليدة");
        wilayaMap.put("Bouira", "البويرة");
        wilayaMap.put("Tamanrasset", "تمنراست");
        wilayaMap.put("Tebessa", "تبسة");
        wilayaMap.put("Tlemcen", "تلمسان");
        wilayaMap.put("Tiaret", "تيارت");
        wilayaMap.put("Tizi Ouzou", "تيزي وزو");
        wilayaMap.put("Algiers", "الجزائر");
        wilayaMap.put("Djelfa", "الجلفة");
        wilayaMap.put("Jijel", "جيجل");
        wilayaMap.put("Setif", "سطيف");
        wilayaMap.put("Saida", "سعيدة");
        wilayaMap.put("Skikda", "سكيكدة");
        wilayaMap.put("Sidi Bel Abbes", "سيدي بلعباس");
        wilayaMap.put("Annaba", "عنابة");
        wilayaMap.put("Guelma", "قالمة");
        wilayaMap.put("Constantine", "قسنطينة");
        wilayaMap.put("Medea", "المدية");
        wilayaMap.put("Mostaganem", "مستغانم");
        wilayaMap.put("Msila", "المسيلة");
        wilayaMap.put("Mascara", "معسكر");
        wilayaMap.put("Ouargla", "ورقلة");
        wilayaMap.put("Oran", "وهران");
        wilayaMap.put("El Bayadh", "البيض");
        wilayaMap.put("Illizi", "إليزي");
        wilayaMap.put("Bordj Bou Arreridj", "برج بوعريريج");
        wilayaMap.put("Boumerdes", "بومرداس");
        wilayaMap.put("El Tarf", "الطارف");
        wilayaMap.put("Tindouf", "تندوف");
        wilayaMap.put("Tissemsilt", "تيسمسيلت");
        wilayaMap.put("El Oued", "الوادي");
        wilayaMap.put("Khenchela", "خنشلة");
        wilayaMap.put("Souk Ahras", "سوق أهراس");
        wilayaMap.put("Tipaza", "تيبازة");
        wilayaMap.put("Mila", "ميلة");
        wilayaMap.put("Ain Defla", "عين الدفلى");
        wilayaMap.put("Naama", "النعامة");
        wilayaMap.put("Ain Temouchent", "عين تموشنت");
        wilayaMap.put("Ghardaia", "غرداية");
        wilayaMap.put("Relizane", "غليزان");
        wilayaMap.put("Timimoun", "تيميمون");
        wilayaMap.put("Bordj Badji Mokhtar", "برج باجي مختار");
        wilayaMap.put("Ouled Djellal", "أولاد جلال");
        wilayaMap.put("Beni Abbes", "بني عباس");
        wilayaMap.put("In Salah", "عين صالح");
        wilayaMap.put("In Guezzam", "عين قزام");
        wilayaMap.put("Touggourt", "تقرت");
        wilayaMap.put("Djanet", "جانت");
        wilayaMap.put("El M'Ghair", "المغير");
        wilayaMap.put("El Menia", "المنيعة");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilaya_details);

        wilayaTitle = findViewById(R.id.wilayaTitle);

        // Récupérer le nom de la wilaya (en anglais)
        String wilayaName = getIntent().getStringExtra("WILAYA_NAME");

        // Trouver le nom arabe correspondant
        String wilayaNameArabic = wilayaMap.get(wilayaName);

        wilayaTitle.setText("Welcome to " + wilayaName + "\n مرحبا بكم في " + wilayaNameArabic);

        ImageButton btnHome = findViewById(R.id.btnHome);

        // Écouteur de clic sur le bouton Home
        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(WilayaDetailsActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });


        // Initialisation des boutons
        Button callButton = findViewById(R.id.btn_call);
        Button smsButton = findViewById(R.id.btn_sms);
        Button emailButton = findViewById(R.id.btn_email);

        // Appel téléphonique
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:+21329214718"));
                startActivity(callIntent);
            }
        });

        // Envoi de SMS
        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setData(Uri.parse("smsto:+21329214718"));
                smsIntent.putExtra("sms_body", "Bonjour, je voudrais plus d'informations sur les sites touristiques.");
                startActivity(smsIntent);
            }
        });

        // Envoi d'Email
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"dta@mta.gov.dz"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Demande d'information");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour,\n\nJe souhaite obtenir des informations sur le tourisme en Algérie.");
                startActivity(Intent.createChooser(emailIntent, "Envoyer un email via"));
            }
        });


        scrollView = findViewById(R.id.scrollView);

        // Associer les sections par leur ID
        descriptionSection = findViewById(R.id.descriptionSection);
        sitesSection = findViewById(R.id.sitesSection);
        dormirSection = findViewById(R.id.dormirSection);
        mangerSection = findViewById(R.id.mangerSection);

        // Initialisation des boutons du menu
        Button btnDescription = findViewById(R.id.btn_description);
        Button btnSites = findViewById(R.id.btn_sites);
        Button btnDormir = findViewById(R.id.btn_dormir);
        Button btnManger = findViewById(R.id.btn_manger);

        // Ajout des listeners pour défiler vers les sections
        btnDescription.setOnClickListener(v -> scrollToView(descriptionSection));
        btnSites.setOnClickListener(v -> scrollToView(sitesSection));
        btnDormir.setOnClickListener(v -> scrollToView(dormirSection));
        btnManger.setOnClickListener(v -> scrollToView(mangerSection));
    }

    /**
     * Fonction pour faire défiler la page jusqu'à une section spécifique
     */
    private void scrollToView(View view){
        scrollView.post(() -> scrollView.smoothScrollTo(0, view.getTop()));
    }
}