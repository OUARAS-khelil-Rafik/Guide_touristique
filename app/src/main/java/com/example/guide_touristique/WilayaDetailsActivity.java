package com.example.guide_touristique;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.ImageView;
import android.graphics.Color;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;

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

    private final Map<String, String[]> siteDescriptionsMap = new HashMap<>();
    private final Map<String, String[]> hotelDescriptionsMap = new HashMap<>();
    private final Map<String, String[]> restaurantDescriptionsMap = new HashMap<>();

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

        // Sites touristiques Adrar
        siteImagesMap.put("Adrar", new Integer[]{R.drawable.site1_adrar, R.drawable.site2_adrar, R.drawable.site3_adrar, R.drawable.site4_adrar});
        siteDescriptionsMap.put("Adrar", new String[]{"Ancien hôpital d’Adrar", "Palais Oukdim", "Mosquée Cheikh Sidi Mohamed Belkabir", "Kasbah Melaka"});

        // Sites touristiques Algiers
        siteImagesMap.put("Algiers", new Integer[]{R.drawable.site1_algiers, R.drawable.site2_algiers, R.drawable.site3_algiers, R.drawable.site4_algiers});
        siteDescriptionsMap.put("Algiers", new String[]{"Casbah d'Alger", "Monument des Martyrs", "Sablette Parc", "Dounia Parc"});

        // Hôtels Adrar
        hotelImagesMap.put("Adrar", new Integer[]{R.drawable.hotel1_adrar, R.drawable.hotel2_adrar, R.drawable.hotel3_adrar, R.drawable.hotel4_adrar});
        hotelDescriptionsMap.put("Adrar", new String[]{"TOUAT Hotel", "Mraguen Adrar Saoura Hotel", "AGADIR Hotel", "TAKIALT Hotel"});

        // Hôtels Algiers
        hotelImagesMap.put("Algiers", new Integer[]{R.drawable.hotel1_algiers, R.drawable.hotel2_algiers, R.drawable.hotel3_algiers, R.drawable.hotel4_algiers});
        hotelDescriptionsMap.put("Algiers", new String[]{"Hilton Hotel", "Hyatt Regency Hotel", "Sofitel Hamma Hotel", "Marriott Hotel Bab Ezzouar"});

        // Restaurants Adrar
        restaurantImagesMap.put("Adrar", new Integer[]{R.drawable.restaurant1_adrar, R.drawable.restaurant2_adrar, R.drawable.restaurant3_adrar, R.drawable.restaurant4_adrar});
        restaurantDescriptionsMap.put("Adrar", new String[]{"Mraguen Restaurant", "Dar Adrar Restaurant", "PALAIS BAB SAHRA Restaurant", "Remontada Restaurant"});

        // Restaurants Algiers
        restaurantImagesMap.put("Algiers", new Integer[]{R.drawable.restaurant1_algiers, R.drawable.restaurant2_algiers, R.drawable.restaurant3_algiers, R.drawable.restaurant4_algiers});
        restaurantDescriptionsMap.put("Algiers", new String[]{"Casbah Istanbul Restaurant", "Holiday Inn Restaurant", "Mega Pizza Restaurant", "Al Fakhama Restaurant"});
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
        TextView site1Text = findViewById(R.id.site1_text);
        TextView site2Text = findViewById(R.id.site2_text);
        TextView site3Text = findViewById(R.id.site3_text);
        TextView site4Text = findViewById(R.id.site4_text);

        site1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        site1Text.setVisibility(View.VISIBLE); // Affiche le texte
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        site1Text.setVisibility(View.GONE); // Cache le texte
                        break;
                }
                return true; // Indique que l'événement est géré
            }
        });

        site2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        site2Text.setVisibility(View.VISIBLE); // Affiche le texte
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        site2Text.setVisibility(View.GONE); // Cache le texte
                        break;
                }
                return true; // Indique que l'événement est géré
            }
        });

        site3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        site3Text.setVisibility(View.VISIBLE); // Affiche le texte
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        site3Text.setVisibility(View.GONE); // Cache le texte
                        break;
                }
                return true; // Indique que l'événement est géré
            }
        });

        site4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        site4Text.setVisibility(View.VISIBLE); // Affiche le texte
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        site4Text.setVisibility(View.GONE); // Cache le texte
                        break;
                }
                return true; // Indique que l'événement est géré
            }
        });

        // Gestion des interactions avec les images des hôtels
        TextView hotel1Text = findViewById(R.id.hotel1_text);
        TextView hotel2Text = findViewById(R.id.hotel2_text);
        TextView hotel3Text = findViewById(R.id.hotel3_text);
        TextView hotel4Text = findViewById(R.id.hotel4_text);

        hotel1.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    hotel1Text.setVisibility(View.VISIBLE);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    hotel1Text.setVisibility(View.GONE);
                    break;
            }
            return true;
        });

        hotel2.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    hotel2Text.setVisibility(View.VISIBLE);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    hotel2Text.setVisibility(View.GONE);
                    break;
            }
            return true;
        });

        hotel3.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    hotel3Text.setVisibility(View.VISIBLE);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    hotel3Text.setVisibility(View.GONE);
                    break;
            }
            return true;
        });

        hotel4.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    hotel4Text.setVisibility(View.VISIBLE);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    hotel4Text.setVisibility(View.GONE);
                    break;
            }
            return true;
        });

        // Gestion des interactions avec les images des restaurants
        TextView restaurant1Text = findViewById(R.id.restaurant1_text);
        TextView restaurant2Text = findViewById(R.id.restaurant2_text);
        TextView restaurant3Text = findViewById(R.id.restaurant3_text);
        TextView restaurant4Text = findViewById(R.id.restaurant4_text);

        restaurant1.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    restaurant1Text.setVisibility(View.VISIBLE);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    restaurant1Text.setVisibility(View.GONE);
                    break;
            }
            return true;
        });

        restaurant2.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    restaurant2Text.setVisibility(View.VISIBLE);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    restaurant2Text.setVisibility(View.GONE);
                    break;
            }
            return true;
        });

        restaurant3.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    restaurant3Text.setVisibility(View.VISIBLE);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    restaurant3Text.setVisibility(View.GONE);
                    break;
            }
            return true;
        });

        restaurant4.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    restaurant4Text.setVisibility(View.VISIBLE);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    restaurant4Text.setVisibility(View.GONE);
                    break;
            }
            return true;
        });

        // Récupérer le nom de la wilaya
        String wilayaName = getIntent().getStringExtra("WILAYA_NAME");

        if (wilayaName == null || !wilayaMap.containsKey(wilayaName)) {
            // Gestion d'erreur : Wilaya inconnue
            wilayaTitle.setText("Wilaya inconnue");
            return;
        }

        String wilayaNameArabic = wilayaMap.get(wilayaName);
        wilayaTitle.setText("Welcome to " + wilayaName + "\n مرحبا بكم في " + wilayaNameArabic);

        // Mise à jour des descriptions avec vérification
        descriptionText.setText(descriptionMap.getOrDefault(wilayaName, "Description not available. \n الوصف غير متوفر."));
        sitesText.setText(sitesMap.getOrDefault(wilayaName, "No information on tourist sites. \n لا توجد معلومات عن المواقع السياحية."));
        hotelText.setText(hotelMap.getOrDefault(wilayaName, "No information on hotels. \n لا يوجد معلومات عن الفنادق."));
        restaurantText.setText(restaurantMap.getOrDefault(wilayaName, "No information on restaurants. \n لا يوجد معلومات عن المطاعم."));

        // Mise à jour de l'image principale de la wilaya
        if (wilayaImageMap.containsKey(wilayaName)) {
            wilayaImage.setImageResource(wilayaImageMap.get(wilayaName));
        } else {
            wilayaImage.setImageResource(R.drawable.wilaya_adrar); // Image par défaut si non trouvée
        }

        // Mise à jour des images des sites touristiques
        if (siteImagesMap.containsKey(wilayaName)) {
            Integer[] siteImages = siteImagesMap.get(wilayaName);
            site1.setImageResource(siteImages[0]);
            site2.setImageResource(siteImages[1]);
            site3.setImageResource(siteImages[2]);
            site4.setImageResource(siteImages[3]);
        } else {
            site1.setImageResource(R.drawable.wilaya_annaba);
            site2.setImageResource(R.drawable.wilaya_algiers);
            site3.setImageResource(R.drawable.wilaya_annaba);
            site4.setImageResource(R.drawable.wilaya_algiers);
        }

        // Mise à jour des images des hôtels
        if (hotelImagesMap.containsKey(wilayaName)) {
            Integer[] hotelImages = hotelImagesMap.get(wilayaName);
            hotel1.setImageResource(hotelImages[0]);
            hotel2.setImageResource(hotelImages[1]);
            hotel3.setImageResource(hotelImages[2]);
            hotel4.setImageResource(hotelImages[3]);
        } else {
            hotel1.setImageResource(R.drawable.wilaya_algiers);
            hotel2.setImageResource(R.drawable.wilaya_adrar);
            hotel3.setImageResource(R.drawable.wilaya_algiers);
            hotel4.setImageResource(R.drawable.wilaya_adrar);
        }

        // Mise à jour des images des restaurants
        if (restaurantImagesMap.containsKey(wilayaName)) {
            Integer[] restaurantImages = restaurantImagesMap.get(wilayaName);
            restaurant1.setImageResource(restaurantImages[0]);
            restaurant2.setImageResource(restaurantImages[1]);
            restaurant3.setImageResource(restaurantImages[2]);
            restaurant4.setImageResource(restaurantImages[3]);
        } else {
            restaurant1.setImageResource(R.drawable.wilaya_adrar);
            restaurant2.setImageResource(R.drawable.wilaya_algiers);
            restaurant3.setImageResource(R.drawable.wilaya_adrar);
            restaurant4.setImageResource(R.drawable.wilaya_algiers);
        }

        // Gestion du bouton Home
        ImageButton btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(v -> onBackPressed());

        // Initialisation des boutons Contact
        initContactButtons();

        // Initialisation des boutons de menu
        initMenuButtons();

        // Ajout des écouteurs de toucher aux images
        setupImageTouchListeners();
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
     * Fonction pour faire défiler la page jusqu'à une section spécifique
     */
    private void scrollToView(View view){
        scrollView.post(() -> scrollView.smoothScrollTo(0, view.getTop() - 50));
    }



    private void setupImageTouchListeners() {
        addTouchListenerToImages(siteImagesMap, siteDescriptionsMap);
        addTouchListenerToImages(hotelImagesMap, hotelDescriptionsMap);
        addTouchListenerToImages(restaurantImagesMap, restaurantDescriptionsMap);
    }

    private void addTouchListenerToImages(Map<String, Integer[]> imagesMap, Map<String, String[]> descriptionsMap) {
        for (String wilaya : imagesMap.keySet()) {
            Integer[] images = imagesMap.get(wilaya);
            String[] descriptions = descriptionsMap.get(wilaya);

            if (images != null && descriptions != null && images.length == descriptions.length) {
                for (int i = 0; i < images.length; i++) {
                    int imageResId = images[i];
                    String description = descriptions[i];

                    ImageView imageView = findViewById(imageResId);
                    if (imageView != null) {
                        imageView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                int action = event.getAction();
                                if (action == MotionEvent.ACTION_DOWN) {
                                    showDescription(imageView, description);
                                } else if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
                                    hideDescription(imageView);
                                }
                                return true;
                            }
                        });
                    }
                }
            }
        }
    }

    private void showDescription(ImageView imageView, String description) {
        // Vérifie si le parent a déjà un TextView pour la description
        TextView textView = (TextView) imageView.getTag();
        if (textView == null) {
            textView = new TextView(this);
            textView.setText(description);
            textView.setTextSize(18);
            textView.setTextColor(Color.WHITE);
            textView.setBackgroundColor(Color.parseColor("#CC000000")); // Noir avec transparence (80%)
            textView.setPadding(20, 10, 20, 10);

            // Positionner le texte au centre de l'image
            imageView.setTag(textView);
            ((android.view.ViewGroup) imageView.getParent()).addView(textView);

            // Ajuster la position du texte au centre
            textView.setX(imageView.getX() + (imageView.getWidth() / 4));
            textView.setY(imageView.getY() + (imageView.getHeight() / 3));
        }

        // Rendre le texte visible
        textView.setVisibility(View.VISIBLE);
    }

    private void hideDescription(ImageView imageView) {
        TextView textView = (TextView) imageView.getTag();
        if (textView != null) {
            textView.setVisibility(View.GONE);
        }
    }
}