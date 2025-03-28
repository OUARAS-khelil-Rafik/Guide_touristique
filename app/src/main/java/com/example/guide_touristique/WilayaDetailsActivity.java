package com.example.guide_touristique;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.HashMap;
import java.util.Map;

public class WilayaDetailsActivity extends AppCompatActivity {

    private TextView wilayaTitle, descriptionText, sitesText, hotelText, restaurantText;
    private ImageView wilayaImage, site1, site2, site3, site4, hotel1, hotel2, hotel3, hotel4, restaurant1, restaurant2, restaurant3, restaurant4;
    private ScrollView scrollView;

    private final Map<String, String> wilayaMap = new HashMap<>();
    private final Map<String, String> descriptionMap = new HashMap<>();
    private final Map<String, String> sitesMap = new HashMap<>();
    private final Map<String, String> hotelMap = new HashMap<>();
    private final Map<String, String> restaurantMap = new HashMap<>();
    private final Map<String, Integer> wilayaImageMap = new HashMap<>();
    private final Map<String, Integer[]> siteImagesMap = new HashMap<>();
    private final Map<String, Integer[]> hotelImagesMap = new HashMap<>();
    private final Map<String, Integer[]> restaurantImagesMap = new HashMap<>();

    // Dictionnaire des wilayas (Anglais -> Arabe)
    {
        // ➜ Initialisation des noms de wilayas
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

        // ➜ Initialisation des images principales des wilayas
        wilayaImageMap.put("Adrar", R.drawable.wilaya_adrar);
        wilayaImageMap.put("Algiers", R.drawable.wilaya_algiers);
        // ➜ Ajouter les autres images...

        // ➜ Initialisation des descriptions
        descriptionMap.put("Adrar", "Adrar is known for its desert landscapes.\n أدرار معروفة بمناظرها الصحراوية.");
        descriptionMap.put("Algiers", "Algiers, the capital of Algeria.\n الجزائر، عاصمة الجزائر.");
        // ➜ Ajouter les autres descriptions...

        // ➜ Initialisation des sites touristiques
        sitesMap.put("Adrar", "Tourist sites in Adrar");
        sitesMap.put("Algiers", "Tourist sites in Algiers");
        // ➜ Ajouter les autres...

        // ➜ Initialisation des hôtels
        hotelMap.put("Adrar", "Hotels in Adrar");
        hotelMap.put("Algiers", "Hotels in Algiers");
        // ➜ Ajouter les autres...

        // ➜ Initialisation des restaurants
        restaurantMap.put("Adrar", "Restaurants in Adrar");
        restaurantMap.put("Algiers", "Restaurants in Algiers");
        // ➜ Ajouter les autres...

        // ➜ Initialisation des images des sites touristiques
        siteImagesMap.put("Adrar", new Integer[]{R.drawable.site1_adrar, R.drawable.site2_adrar, R.drawable.site3_adrar, R.drawable.site4_adrar});
        siteImagesMap.put("Algiers", new Integer[]{R.drawable.site1_algiers, R.drawable.site2_algiers, R.drawable.site3_algiers, R.drawable.site4_algiers});
        // ➜ Ajouter les autres...

        // ➜ Initialisation des images des hôtels
        hotelImagesMap.put("Adrar", new Integer[]{R.drawable.hotel1_adrar, R.drawable.hotel2_adrar, R.drawable.hotel3_adrar, R.drawable.hotel4_adrar});
        hotelImagesMap.put("Algiers", new Integer[]{R.drawable.hotel1_algiers, R.drawable.hotel2_algiers, R.drawable.hotel3_algiers, R.drawable.hotel4_algiers});
        // ➜ Ajouter les autres...

        // ➜ Initialisation des images des restaurants
        restaurantImagesMap.put("Adrar", new Integer[]{R.drawable.restaurant1_adrar, R.drawable.restaurant2_adrar, R.drawable.restaurant3_adrar, R.drawable.restaurant4_adrar});
        restaurantImagesMap.put("Algiers", new Integer[]{R.drawable.restaurant1_algiers, R.drawable.restaurant2_algiers, R.drawable.restaurant3_algiers, R.drawable.restaurant4_algiers});
        // ➜ Ajouter les autres...
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilaya_details);

        wilayaTitle = findViewById(R.id.wilayaTitle);
        descriptionText = findViewById(R.id.tv_description);
        sitesText = findViewById(R.id.tv_site_tour_description);
        hotelText = findViewById(R.id.tv_hotel_description);
        restaurantText = findViewById(R.id.tv_restaurant_description);
        wilayaImage = findViewById(R.id.wilayaImage);
        site1 = findViewById(R.id.site1);
        site2 = findViewById(R.id.site2);
        site3 = findViewById(R.id.site3);
        site4 = findViewById(R.id.site4);
        hotel1 = findViewById(R.id.hotel1);
        hotel2 = findViewById(R.id.hotel2);
        hotel3 = findViewById(R.id.hotel3);
        hotel4 = findViewById(R.id.hotel4);
        restaurant1 = findViewById(R.id.restaurant1);
        restaurant2 = findViewById(R.id.restaurant2);
        restaurant3 = findViewById(R.id.restaurant3);
        restaurant4 = findViewById(R.id.restaurant4);
        scrollView = findViewById(R.id.scrollView);


        // Récupérer le nom de la wilaya
        String wilayaName = getIntent().getStringExtra("WILAYA_NAME");
        String wilayaNameArabic = wilayaMap.get(wilayaName);
        wilayaTitle.setText("Welcome to " + wilayaName + "\n مرحبا بكم في " + wilayaNameArabic);


        // Mettre à jour la descriptions
        descriptionText.setText(descriptionMap.get(wilayaName));
        sitesText.setText(sitesMap.get(wilayaName));
        hotelText.setText(hotelMap.get(wilayaName));
        restaurantText.setText(restaurantMap.get(wilayaName));

        // Mettre à jour l'image principale de la wilaya
        wilayaImage.setImageResource(wilayaImageMap.get(wilayaName));

        // Mettre à jour les images des sites touristiques, hôtels et restaurants
        site1.setImageResource(siteImagesMap.get(wilayaName)[0]);
        site2.setImageResource(siteImagesMap.get(wilayaName)[1]);
        site3.setImageResource(siteImagesMap.get(wilayaName)[2]);
        site4.setImageResource(siteImagesMap.get(wilayaName)[3]);
        hotel1.setImageResource(hotelImagesMap.get(wilayaName)[0]);
        hotel2.setImageResource(hotelImagesMap.get(wilayaName)[1]);
        hotel3.setImageResource(hotelImagesMap.get(wilayaName)[2]);
        hotel4.setImageResource(hotelImagesMap.get(wilayaName)[3]);
        restaurant1.setImageResource(restaurantImagesMap.get(wilayaName)[0]);
        restaurant2.setImageResource(restaurantImagesMap.get(wilayaName)[1]);
        restaurant3.setImageResource(restaurantImagesMap.get(wilayaName)[2]);
        restaurant4.setImageResource(restaurantImagesMap.get(wilayaName)[3]);

        // Ajouter l'effet d'affichage du texte au toucher de l'image
        addImageClickEffect(site1, "Tourist Site 1");
        addImageClickEffect(site2, "Tourist Site 2");
        addImageClickEffect(site3, "Tourist Site 3");
        addImageClickEffect(site4, "Tourist Site 4");
        addImageClickEffect(hotel1, "Hotel 1");
        addImageClickEffect(hotel2, "Hotel 2");
        addImageClickEffect(hotel3, "Hotel 3");
        addImageClickEffect(hotel4, "Hotel 4");
        addImageClickEffect(restaurant1, "Restaurant 1");
        addImageClickEffect(restaurant2, "Restaurant 2");
        addImageClickEffect(restaurant3, "Restaurant 3");
        addImageClickEffect(restaurant4, "Restaurant 4");

        // Gestion du bouton Home
        ImageButton btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(v -> onBackPressed());

        // Initialisation des boutons Contact
        initContactButtons();

        // Initialisation des boutons de menu
        initMenuButtons();

        scrollView = findViewById(R.id.scrollView);
    }


    /**
     * Initialise les boutons d'appel, SMS et email
     */
    private void initContactButtons() {
        Button callButton = findViewById(R.id.btn_call);
        Button smsButton = findViewById(R.id.btn_sms);
        Button emailButton = findViewById(R.id.btn_email);

        callButton.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:+21329214718"));
            startActivity(callIntent);
        });

        smsButton.setOnClickListener(v -> {
            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setData(Uri.parse("smsto:+21329214718"));
            smsIntent.putExtra("sms_body", "Bonjour, je voudrais plus d'informations sur les sites touristiques.");
            startActivity(smsIntent);
        });

        emailButton.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"dta@mta.gov.dz"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Demande d'information");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour,\n\nJe souhaite obtenir des informations sur le tourisme en Algérie.");
            startActivity(Intent.createChooser(emailIntent, "Envoyer un email via"));
        });
    }

    /**
     * Initialise les boutons du menu de navigation
     */
    private void initMenuButtons() {
        Button btnDescription = findViewById(R.id.btn_description);
        Button btnSites = findViewById(R.id.btn_sites);
        Button btnDormir = findViewById(R.id.btn_dormir);
        Button btnManger = findViewById(R.id.btn_manger);

        btnDescription.setOnClickListener(v -> scrollToView(findViewById(R.id.descriptionSection)));
        btnSites.setOnClickListener(v -> scrollToView(findViewById(R.id.sitesSection)));
        btnDormir.setOnClickListener(v -> scrollToView(findViewById(R.id.dormirSection)));
        btnManger.setOnClickListener(v -> scrollToView(findViewById(R.id.mangerSection)));
    }

    /**
     * Fonction pour ajouter l'effet d'affichage du texte au centre de l'image avec fond semi-transparent
     */
    private void addImageClickEffect(ImageView imageView, String text) {
        imageView.setOnClickListener(v -> {
            TextView overlayText = new TextView(this);
            overlayText.setText(text);
            overlayText.setTextSize(18);
            overlayText.setTextColor(Color.WHITE);
            overlayText.setBackgroundColor(Color.argb(200, 0, 0, 0));
            overlayText.setPadding(10, 10, 10, 10);
            overlayText.setGravity(View.TEXT_ALIGNMENT_CENTER);

            // Afficher le texte au centre de l'image
            imageView.setAlpha(0.8f);
            imageView.postDelayed(() -> {
                imageView.setAlpha(1.0f);
            }, 2000);
        });
    }

    /**
     * Fonction pour faire défiler la page jusqu'à une section spécifique
     */
    private void scrollToView(View view){
        scrollView.post(() -> scrollView.smoothScrollTo(0, view.getTop() - 50));
    }
}