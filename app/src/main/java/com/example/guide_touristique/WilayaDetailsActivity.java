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
    private ImageView wilayaImage;
    private ScrollView scrollView;

    // Maps pour stocker les données
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

    // Tableaux d'IDs pour les vues répétitives
    private final int[] siteImageIds = {R.id.site1, R.id.site2, R.id.site3, R.id.site4};
    private final int[] siteTextIds = {R.id.site1_text, R.id.site2_text, R.id.site3_text, R.id.site4_text};
    private final int[] hotelImageIds = {R.id.hotel1, R.id.hotel2, R.id.hotel3, R.id.hotel4};
    private final int[] hotelTextIds = {R.id.hotel1_text, R.id.hotel2_text, R.id.hotel3_text, R.id.hotel4_text};
    private final int[] restaurantImageIds = {R.id.restaurant1, R.id.restaurant2, R.id.restaurant3, R.id.restaurant4};
    private final int[] restaurantTextIds = {R.id.restaurant1_text, R.id.restaurant2_text, R.id.restaurant3_text, R.id.restaurant4_text};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilaya_details);

        initViews();
        initData();
        setupTouchListeners();

        // Récupérer le nom de la wilaya
        String wilayaName = getIntent().getStringExtra("WILAYA_NAME");

        if (wilayaName == null || !wilayaMap.containsKey(wilayaName)) {
            wilayaTitle.setText("Wilaya inconnue");
            return;
        }

        updateUI(wilayaName);
        initContactButtons();
        initMenuButtons();
    }

    private void initViews() {
        wilayaTitle = findViewById(R.id.wilayaTitle);
        descriptionText = findViewById(R.id.tv_description);
        sitesText = findViewById(R.id.tv_site_tour_description);
        hotelText = findViewById(R.id.tv_hotel_description);
        restaurantText = findViewById(R.id.tv_restaurant_description);
        wilayaImage = findViewById(R.id.wilayaImage);
        scrollView = findViewById(R.id.scrollView);
    }

    private void initData() {
        // Initialisation des noms de wilayas (Anglais -> Arabe)
        wilayaMap.put("Adrar", "أدرار");
        wilayaMap.put("Algiers", "الجزائر");
        // Ajouter les autres wilayas...

        // Initialisation des images principales
        wilayaImageMap.put("Adrar", R.drawable.wilaya_adrar);
        wilayaImageMap.put("Algiers", R.drawable.wilaya_algiers);
        // Ajouter les autres images...

        // Initialisation des descriptions
        descriptionMap.put("Adrar", "Adrar is known for its desert landscapes.\n أدرار معروفة بمناظرها الصحراوية.");
        descriptionMap.put("Algiers", "Algiers, the capital of Algeria.\n الجزائر، عاصمة الجزائر.");
        // Ajouter les autres descriptions...

        // Initialisation des textes généraux
        sitesMap.put("Adrar", "Tourist sites in Adrar");
        hotelMap.put("Adrar", "Hotels in Adrar");
        restaurantMap.put("Adrar", "Restaurants in Adrar");
        // Ajouter les autres...

        // Initialisation des images et descriptions pour les sites, hôtels et restaurants
        initCategoryData("Adrar",
                new Integer[]{R.drawable.site1_adrar, R.drawable.site2_adrar, R.drawable.site3_adrar, R.drawable.site4_adrar},
                new String[]{"Ancien hôpital d'Adrar", "Palais Oukdim", "Mosquée Cheikh Sidi Mohamed Belkabir", "Kasbah Melaka"},
                new Integer[]{R.drawable.hotel1_adrar, R.drawable.hotel2_adrar, R.drawable.hotel3_adrar, R.drawable.hotel4_adrar},
                new String[]{"TOUAT Hotel", "Mraguen Adrar Saoura Hotel", "AGADIR Hotel", "TAKIALT Hotel"},
                new Integer[]{R.drawable.restaurant1_adrar, R.drawable.restaurant2_adrar, R.drawable.restaurant3_adrar, R.drawable.restaurant4_adrar},
                new String[]{"Mraguen Restaurant", "Dar Adrar Restaurant", "PALAIS BAB SAHRA Restaurant", "Remontada Restaurant"});

        initCategoryData("Algiers",
                new Integer[]{R.drawable.site1_algiers, R.drawable.site2_algiers, R.drawable.site3_algiers, R.drawable.site4_algiers},
                new String[]{"Casbah d'Alger", "Monument des Martyrs", "Sablette Parc", "Dounia Parc"},
                new Integer[]{R.drawable.hotel1_algiers, R.drawable.hotel2_algiers, R.drawable.hotel3_algiers, R.drawable.hotel4_algiers},
                new String[]{"Hilton Hotel", "Hyatt Regency Hotel", "Sofitel Hamma Hotel", "Marriott Hotel Bab Ezzouar"},
                new Integer[]{R.drawable.restaurant1_algiers, R.drawable.restaurant2_algiers, R.drawable.restaurant3_algiers, R.drawable.restaurant4_algiers},
                new String[]{"Casbah Istanbul Restaurant", "Holiday Inn Restaurant", "Mega Pizza Restaurant", "Al Fakhama Restaurant"});
    }

    private void initCategoryData(String wilaya, Integer[] siteImages, String[] siteDescs,
                                  Integer[] hotelImages, String[] hotelDescs,
                                  Integer[] restaurantImages, String[] restaurantDescs) {
        siteImagesMap.put(wilaya, siteImages);
        siteDescriptionsMap.put(wilaya, siteDescs);
        hotelImagesMap.put(wilaya, hotelImages);
        hotelDescriptionsMap.put(wilaya, hotelDescs);
        restaurantImagesMap.put(wilaya, restaurantImages);
        restaurantDescriptionsMap.put(wilaya, restaurantDescs);
    }

    private void updateUI(String wilayaName) {
        String wilayaNameArabic = wilayaMap.get(wilayaName);
        wilayaTitle.setText("Welcome to " + wilayaName + "\n مرحبا بكم في " + wilayaNameArabic);

        // Mise à jour des textes
        descriptionText.setText(descriptionMap.getOrDefault(wilayaName, "Description not available. \n الوصف غير متوفر."));
        sitesText.setText(sitesMap.getOrDefault(wilayaName, "No information on tourist sites. \n لا توجد معلومات عن المواقع السياحية."));
        hotelText.setText(hotelMap.getOrDefault(wilayaName, "No information on hotels. \n لا يوجد معلومات عن الفنادق."));
        restaurantText.setText(restaurantMap.getOrDefault(wilayaName, "No information on restaurants. \n لا يوجد معلومات عن المطاعم."));

        // Mise à jour de l'image principale
        wilayaImage.setImageResource(wilayaImageMap.getOrDefault(wilayaName, R.drawable.wilaya_adrar));

        // Mise à jour des images et textes pour chaque catégorie
        updateCategoryImages(wilayaName, siteImagesMap, siteImageIds, R.drawable.wilaya_annaba);
        updateCategoryImages(wilayaName, hotelImagesMap, hotelImageIds, R.drawable.wilaya_algiers);
        updateCategoryImages(wilayaName, restaurantImagesMap, restaurantImageIds, R.drawable.wilaya_adrar);

        // Mise à jour des descriptions
        updateCategoryDescriptions(wilayaName, siteDescriptionsMap, siteTextIds);
        updateCategoryDescriptions(wilayaName, hotelDescriptionsMap, hotelTextIds);
        updateCategoryDescriptions(wilayaName, restaurantDescriptionsMap, restaurantTextIds);
    }

    private void updateCategoryImages(String wilayaName, Map<String, Integer[]> imagesMap, int[] viewIds, int defaultImage) {
        Integer[] images = imagesMap.get(wilayaName);
        if (images != null && images.length == viewIds.length) {
            for (int i = 0; i < viewIds.length; i++) {
                ImageView imageView = findViewById(viewIds[i]);
                imageView.setImageResource(images[i]);
            }
        } else {
            for (int viewId : viewIds) {
                ImageView imageView = findViewById(viewId);
                imageView.setImageResource(defaultImage);
            }
        }
    }

    private void updateCategoryDescriptions(String wilayaName, Map<String, String[]> descriptionsMap, int[] textViewIds) {
        String[] descriptions = descriptionsMap.get(wilayaName);
        if (descriptions != null && descriptions.length == textViewIds.length) {
            for (int i = 0; i < textViewIds.length; i++) {
                TextView textView = findViewById(textViewIds[i]);
                textView.setText(descriptions[i]);
            }
        }
    }

    private void setupTouchListeners() {
        setupTouchListenersForCategory(siteImageIds, siteTextIds);
        setupTouchListenersForCategory(hotelImageIds, hotelTextIds);
        setupTouchListenersForCategory(restaurantImageIds, restaurantTextIds);
    }

    private void setupTouchListenersForCategory(int[] imageViewIds, int[] textViewIds) {
        for (int i = 0; i < imageViewIds.length; i++) {
            ImageView imageView = findViewById(imageViewIds[i]);
            TextView textView = findViewById(textViewIds[i]);

            if (imageView != null && textView != null) {
                final int finalI = i;
                imageView.setOnTouchListener((v, event) -> {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            textView.setVisibility(View.VISIBLE);
                            break;
                        case MotionEvent.ACTION_UP:
                        case MotionEvent.ACTION_CANCEL:
                            textView.setVisibility(View.GONE);
                            break;
                    }
                    return true;
                });
            }
        }
    }

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

    private void scrollToView(View view) {
        scrollView.post(() -> scrollView.smoothScrollTo(0, view.getTop() - 50));
    }

    // Gestion du bouton Home
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}