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

        // Gestion du bouton Home
        ImageButton btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(v -> onBackPressed());
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

        // Initialisation des images principales
        wilayaImageMap.put("Adrar", R.drawable.wilaya_adrar);
        wilayaImageMap.put("Algiers", R.drawable.wilaya_algiers);
        // Ajouter les autres images...

        // Initialisation des descriptions
        descriptionMap.put("Adrar", "Adrar is known for its vast desert landscapes, ancient ksars (fortified villages), and the stunning Tassili N'Ajjer rock formations. The region is a gateway to the Sahara and offers unique cultural heritage.\n أدرار معروفة بمناظرها الصحراوية الشاسعة، قصورها القديمة (القرى المحصنة)، وتشكيلات تاسيلي ناجر الصخرية المذهلة. المنطقة تعتبر بوابة للصحراء وتوفر تراثاً ثقافياً فريداً.");

        descriptionMap.put("Algiers", "Algiers, the capital of Algeria, is a vibrant coastal city blending French colonial architecture with modern developments. Key landmarks include the Casbah (a UNESCO World Heritage Site), the Great Mosque, and the Martyrs' Memorial.\n الجزائر، عاصمة الجزائر، هي مدينة ساحلية نابضة بالحياة تجمع بين العمارة الاستعمارية الفرنسية والتطورات الحديثة. من أبرز معالمها القصبة (موقع تراث عالمي لليونسكو)، الجامع الكبير، ونصب الشهداء.");

        descriptionMap.put("Oran", "Oran is a major port city on the Mediterranean, famous for its Rai music, historical sites like Santa Cruz Fort, and vibrant nightlife. It combines Spanish, French, and Algerian influences.\n وهران هي مدينة ميناء كبرى على البحر الأبيض المتوسط، تشتهر بموسيقى الراي، المواقع التاريخية مثل حصن سانتا كروز، وحياة ليلية نابضة بالحياة. تجمع بين التأثيرات الإسبانية والفرنسية والجزائرية.");

        descriptionMap.put("Constantine", "Constantine, the 'City of Bridges,' is perched on rocky cliffs and features breathtaking gorges, historic palaces, and the iconic Sidi M'Cid suspension bridge.\n قسنطينة، 'مدينة الجسور،' تقع على منحدرات صخرية وتتميز بمناظر الخوانق الرائعة، القصور التاريخية، وجسر سيدي مسيد المعلق الشهير.");
        // Ajouter les autres descriptions...

        // Initialisation des textes généraux
        sitesMap.put("Adrar",
                "Tourist sites in Adrar:\n" +
                        "• Ancient Hospital of Adrar: A historic colonial-era building.\n" +
                        "• Oukdim Palace: A traditional Saharan fortress with unique architecture.\n" +
                        "• Cheikh Sidi Mohamed Belkabir Mosque: A spiritual center with beautiful Saharan design.\n" +
                        "• Melaka Kasbah: A well-preserved ksar (fortified village).\n\n" +
                        "مواقع سياحية في أدرار:\n" +
                        "• المستشفى القديم لأدرار : مبنى تاريخي من العهد الاستعماري.\n" +
                        "• قصر أوكديم : حصن صحراوي تقليدي بهندسة معمارية فريدة.\n" +
                        "• مسجد الشيخ سيدي محمد البلكبير : مركز روحاني بتصميم صحراوي جميل.\n" +
                        "• قصبة ملاكة : قصر محصّن محفوظ جيداً.");
        sitesMap.put("Algiers",
                "Tourist sites in Algiers:\n" +
                        "• Casbah of Algiers: UNESCO-listed ancient medina with Ottoman-era architecture.\n" +
                        "• Martyrs' Memorial: Iconic monument honoring Algeria’s independence war.\n" +
                        "• Sablette Parc: A seaside park with stunning Mediterranean views.\n" +
                        "• Dounia Parc: Family-friendly amusement park.\n\n" +
                        "مواقع سياحية في الجزائر:\n" +
                        "• قصبة الجزائر : مدينة قديمة مدرجة في اليونسكو بهندسة عثمانية.\n" +
                        "• نصب الشهداء : معلم شهير يخلد حرب التحرير الجزائرية.\n" +
                        "• حديقة السابلات : حديقة ساحلية بإطلالات رائعة على البحر.\n" +
                        "• حديقة دنيا : مدينة ألعاب عائلية.");
        sitesMap.put("Oran",
                "Tourist sites in Oran:\n" +
                        "• Santa Cruz Fort: A historic Spanish fortress with panoramic city & sea views.\n" +
                        "• Bey’s Palace: 18th-century Ottoman palace showcasing Moorish architecture.\n" +
                        "• Le Théâtre d’Oran: A beautifully restored French colonial-era theater.\n" +
                        "• Front de Mer Promenade: Scenic coastal walkway with cafes and beaches.\n\n" +
                        "مواقع سياحية في وهران:\n" +
                        "• حصن سانتا كروز : قلعة إسبانية تاريخية بإطلالة بانورامية على المدينة والبحر.\n" +
                        "• قصر الباي : قصر عثماني من القرن الـ18 يجسد العمارة المغاربية.\n" +
                        "• مسرح وهران : مسرح فرنسي قديم تم ترميمه بشكل رائع.\n" +
                        "• كورنيش وهران : ممشى ساحلي خلاب مع مقاهي وشواطئ.");
        sitesMap.put("Constantine",
                "Tourist sites in Constantine:\n" +
                        "• Sidi M’Cid Bridge: A dramatic suspension bridge over the Rhumel Gorge.\n" +
                        "• Ahmed Bey Palace: 19th-century palace with intricate mosaics and gardens.\n" +
                        "• Emir Abdelkader Mosque: One of Africa’s largest mosques with stunning design.\n" +
                        "• Cirta Museum: Showcases Roman and Numidian artifacts.\n\n" +
                        "مواقع سياحية في قسنطينة:\n" +
                        "• جسر سيدي مسيد : جسر معلق مذهل فوق وادي الرمال.\n" +
                        "• قصر أحمد باي : قصر من القرن الـ19 بفسيفساء وحدائق رائعة.\n" +
                        "• مسجد الأمير عبد القادر : أحد أكبر المساجد في إفريقيا بتصميم خلاب.\n" +
                        "• متحف سيرتا : يعرض قطعاً أثرية رومانية ونوميدية.");



        hotelMap.put("Adrar",
                "Hotels in Adrar:\n" +
                        "• TOUAT Hotel: Comfortable stay with Saharan hospitality.\n" +
                        "• Mraguen Adrar Saoura Hotel: Modern amenities in a desert setting.\n" +
                        "• AGADIR Hotel: Known for its traditional decor.\n" +
                        "• TAKIALT Hotel: Budget-friendly option near major sites.\n\n" +
                        "فنادق في أدرار:\n" +
                        "• فندق توات : إقامة مريحة مع كرم الضيافة الصحراوية.\n" +
                        "• فندق مرقن أدرار الساورة : مرافق حديثة في وسط صحراوي.\n" +
                        "• فندق أغادير : معروف بديكوره التقليدي.\n" +
                        "• فندق تاقيلت : خيار اقتصادي قرب المعالم السياحية.");
        hotelMap.put("Algiers",
                "Hotels in Algiers:\n" +
                        "• Hilton Hotel: Luxury stay with sea views.\n" +
                        "• Hyatt Regency Hotel: High-end accommodations in the city center.\n" +
                        "• Sofitel Hamma Hotel: Elegant French-inspired hotel.\n" +
                        "• Marriott Hotel Bab Ezzouar: Business-friendly with modern facilities.\n\n" +
                        "فنادق في الجزائر:\n" +
                        "• فندق هيلتون : إقامة فاخرة مع إطلالة على البحر.\n" +
                        "• فندق حياة ريجنسي : إقامة راقية في وسط المدينة.\n" +
                        "• فندق سوفيتيل حامة : فندق أنيق على الطراز الفرنسي.\n" +
                        "• فندق ماريوت باب الزوار : مناسب لرجال الأعمال بمرافق حديثة.");
        hotelMap.put("Oran",
                "Hotels in Oran:\n" +
                        "• Sheraton Oran Hotel: Luxury beachfront hotel with pools and spas.\n" +
                        "• Mercure Oran Hotel: Modern hotel near the city center.\n" +
                        "• Ibis Oran Hotel: Budget-friendly option with reliable service.\n" +
                        "• Royal Hotel Oran: Historic hotel with Art Deco influences.\n\n" +
                        "فنادق في وهران:\n" +
                        "• فندق شيراتون وهران : فندق فاخر على الشاطئ مع مسابح ومنتجعات صحية.\n" +
                        "• فندق ميركور وهران : فندق حديث قرب وسط المدينة.\n" +
                        "• فندق إيبيس وهران : خيار اقتصادي مع خدمة موثوقة.\n" +
                        "• فندق رويال وهران : فندق تاريخي بتأثيرات آرت ديكو.");
        hotelMap.put("Constantine",
                "Hotels in Constantine:\n" +
                        "• Ibis Constantine Hotel: Reliable chain hotel with city views.\n" +
                        "• Méridien Constantine Hotel: Luxury option with a rooftop pool.\n" +
                        "• Hotel Les Emirides: Mid-range hotel near historical sites.\n" +
                        "• Hotel Constantine: Budget stay with traditional charm.\n\n" +
                        "فنادق في قسنطينة:\n" +
                        "• فندق إيبيس قسنطينة : فندق سلسلة موثوقة بإطلالة على المدينة.\n" +
                        "• فندق ميريديان قسنطينة : خيار فاخر مع مسبح على السطح.\n" +
                        "• فندق الأمراء : فندق متوسط المستوى قرب المواقع التاريخية.\n" +
                        "• فندق قسنطينة : إقامة اقتصادية بسحر تقليدي.");


        restaurantMap.put("Adrar",
                "Restaurants in Adrar:\n" +
                        "• Mraguen Restaurant: Offers traditional Algerian dishes.\n" +
                        "• Dar Adrar Restaurant: Authentic Saharan cuisine in a cultural setting.\n" +
                        "• PALAIS BAB SAHRA Restaurant: Fine dining with local flavors.\n" +
                        "• Remontada Restaurant: Popular for grilled meats and tajines.\n\n" +
                        "مطاعم في أدرار:\n" +
                        "• مطعم مرقن : يقدم أطباق جزائرية تقليدية.\n" +
                        "• مطعم دار أدرار : أكلات صحراوية أصيلة في جو ثقافي.\n" +
                        "• مطعم قصر باب الصحراء : تجربة طعام راقية بنكهات محلية.\n" +
                        "• مطعم ريمونتادا : مشهور باللحوم المشوية والطاجين.");
        restaurantMap.put("Algiers",
                "Restaurants in Algiers:\n" +
                        "• Casbah Istanbul Restaurant: Mix of Algerian and Turkish cuisine.\n" +
                        "• Holiday Inn Restaurant: International dishes in a hotel setting.\n" +
                        "• Mega Pizza Restaurant: Popular for fast food and pizzas.\n" +
                        "• Al Fakhama Restaurant: High-end seafood and traditional meals.\n\n" +
                        "مطاعم في الجزائر:\n" +
                        "• مطعم قصبة إسطنبول : مزيج من المطبخ الجزائري والتركي.\n" +
                        "• مطعم هوليداي إن : أطباق عالمية في جو فندقي.\n" +
                        "• مطعم ميجا بيتزا : مشهور بالوجبات السريعة والبيتزا.\n" +
                        "• مطعم الفخامة : أطباق بحرية فاخرة وأكلات تقليدية.");
        restaurantMap.put("Oran",
                "Restaurants in Oran:\n" +
                        "• Le Petit Rocher: Famous for fresh seafood and Mediterranean dishes.\n" +
                        "• Restaurant El Bahia: Serves authentic Oranese cuisine like karantika.\n" +
                        "• La Dégustation: Fine dining with French-Algerian fusion.\n" +
                        "• Café Santa Cruz: Iconic café near the fort with Spanish-inspired snacks.\n\n" +
                        "مطاعم في وهران:\n" +
                        "• مطعم لو بيتي روشيه : مشهور بالمأكولات البحرية والأطباق المتوسطية.\n" +
                        "• مطعم الباهية : يقدم أكلات وهرانية أصيلة مثل الكارنتيكا.\n" +
                        "• مطعم لا ديغوستاسيون : أكلات راقية بمزيج فرنسي-جزائري.\n" +
                        "• مقهى سانتا كروز : مقهى شهير قرب الحصن يقدم وجبات خفيفة إسبانية.");
        restaurantMap.put("Constantine",
                "Restaurants in Constantine:\n" +
                        "• Restaurant Le Majestic: Elegant dining with Algerian-French cuisine.\n" +
                        "• Dar El Hamra: Traditional dishes in a historic house setting.\n" +
                        "• Le Panoramique: Offers cliffside views and local specialties.\n" +
                        "• Café Diwan: Cozy spot for coffee and Constantine-style pastries.\n\n" +
                        "مطاعم في قسنطينة:\n" +
                        "• مطعم لوماجستيك : أكلات راقية بمزيج جزائري-فرنسي.\n" +
                        "• مطعم دار الحمراء : أطباق تقليدية في جو منزل تاريخي.\n" +
                        "• مطعم لوبانوراميك : إطلالات على المنحدرات وأكلات محلية.\n" +
                        "• مقهى ديوان : مكان مريح للقهوة وحلويات قسنطينية.");
        // Ajouter les autres...

        // Initialisation des images et descriptions pour les sites, hôtels et restaurants
        initCategoryData("Adrar",
                new Integer[]{R.drawable.site1_adrar, R.drawable.site2_adrar, R.drawable.site3_adrar, R.drawable.site4_adrar},
                new String[]{"Ancien hôpital d'Adrar", "Palais Oukdim", "Mosquée Cheikh Sidi Mohamed Belkabir", "Kasbah Melaka"},
                new Integer[]{R.drawable.hotel1_adrar, R.drawable.hotel2_adrar, R.drawable.hotel3_adrar, R.drawable.hotel4_adrar},
                new String[]{"TOUAT Hotel \n 4000DZ/Night", "Mraguen Adrar Saoura Hotel \n 8000DZ/Night", "AGADIR Hotel \n 5500DZ/Night", "TAKIALT Hotel \n 4500DZ/Night"},
                new Integer[]{R.drawable.restaurant1_adrar, R.drawable.restaurant2_adrar, R.drawable.restaurant3_adrar, R.drawable.restaurant4_adrar},
                new String[]{"Mraguen Restaurant", "Dar Adrar Restaurant", "PALAIS BAB SAHRA Restaurant", "Remontada Restaurant"});

        initCategoryData("Algiers",
                new Integer[]{R.drawable.site1_algiers, R.drawable.site2_algiers, R.drawable.site3_algiers, R.drawable.site4_algiers},
                new String[]{"Casbah d'Alger", "Monument des Martyrs", "Sablette Parc", "Dounia Parc"},
                new Integer[]{R.drawable.hotel1_algiers, R.drawable.hotel2_algiers, R.drawable.hotel3_algiers, R.drawable.hotel4_algiers},
                new String[]{"Hilton Hotel \n 6500DZ/Night", "Hyatt Regency Hotel \n 9000DZ/Night", "Sofitel Hamma Hotel \n 7500DZ/Night", "Marriott Hotel Bab Ezzouar \n 6000DZ/Night"},
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
}