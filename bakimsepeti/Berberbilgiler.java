package com.example.roko;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Berberbilgiler extends AppCompatActivity {
    EditText adres;
    Spinner ilin, ilcenin;
    Button okey;
    FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("isletmeberber");
    FirebaseDatabase database2=FirebaseDatabase.getInstance();
    DatabaseReference mio=database2.getReference("isletme");
    private String[] iller = {"ADANA", "ADIYAMAN", "AFYONKARAHİSAR", "AĞRI", "AMASYA", "ANKARA", "ANTALYA", "ARTVİN", "AYDIN", "BALIKESİR", "BİLECİK", "BİNGÖL", "BİTLİS", "BOLU", "BURDUR", "BURSA", "ÇANAKKALE", "ÇANKIRI", "ÇORUM", "DENİZLİ", "DİYARBAKIR", "EDİRNE", "ELAZIĞ", "ERZİNCAN", "ERZURUM", "ESKİŞEHİR", "GAZİANTEP", "GİRESUN", "GÜMÜŞHANE", "HAKKARİ", "HATAY", "ISPARTA", "MERSİN", "İSTANBUL",
            "İZMİR", "KARS", "KASTAMONU", "KAYSERİ", "KIRKLARELİ", "KIRŞEHİR", "KOCAELİ", "KONYA", "KÜTAHYA", "MALATYA", "MANİSA", "KAHRAMANMARAŞ", "MARDİN", "MUĞLA", "MUŞ", "NEVŞEHİR", "NİĞDE", "ORDU", "RİZE", "SAKARYA", "SAMSUN", "SİİRT", "SİNOP", "SİVAS", "TEKİRDAĞ", "TOKAT", "TRABZON", "TUNCELİ", "ŞANLIURFA", "UŞAK", "VAN", "YOZGAT", "ZONGULDAK", "AKSARAY", "BAYBURT", "KARAMAN", "KIRIKKALE", "BATMAN", "ŞIRNAK", "BARTIN", "ARDAHAN", "IĞDIR", "YALOVA", "KARABÜK", "KİLİS",
            "OSMANİYE", "DÜZCE"};
    private String[] ilAdana = {"Seyhan", "Ceyhan", "Feke", "Karaisalı", "Karataş", "Kozan", "Pozantı", "Saimbeyli", "Tufanbeyli", "Yumurtalık", "Yüreğir", "Aladağ", "İmamoğlu", "Sarıçam", "Çukurova"};
    private String[] ilAdıyaman = {"Merkez", "Besni", "Çelikhan", "Gerger", "Gölbaşı", "Kahta", "Samsat", "Sincik", "Tut"};
    private String[] ilAfyonkarahisar = {"Merkez", "Bolvadin", "Çay", "Dazkırı", "Dinar", "Emirdağİhsaniye", "Sandıklı", "Sinanpaşa", "Sultandağı", "Şuhut", "Başmakçı", "Bayat", "İscehisar", "Çobanlar", "Evciler", "Hocalar", "Kızılören"};
    private String[] ilAğrı = {"Merkez", "Diyadin", "Doğubayazıt", "Eleşkirt", "Hamur", "Patnos", "Taşlıçay", "Tutak"};
    private String[] ilAmasya = {"Merkez", "Göynücek", "Gümüşhacıköy", "Merzifon", "Suluova", "Taşova", "Hamamözü"};
    private String[] ilAnkara = {"Altındağ", "Ayaş", "Bala", "Beypazarı", "Çamlıdere", "Çankaya", "Çubuk", "Elmadağ", "Güdül", "Haymana", "Kalecik", "Kızılcahamam", "Nallıhan", "Gölbaşı", "Keçiören", "Mamak", "Sincan", "Kazan", "Akyurt", "Etimesgut", "Evren", "Pursaklar"};
    private String[] ilAntalya = {"Akseki", "Alanya", "Elmalı", "Finike", "Gazipaşa", "Gündoğmuş", "Kaş", "Korkuteli", "Kumluca", "Manavgat", "Serik", "Demre", "İbradı", "Kemer", "Aksu", "Döşemealtı", "Kepez", "Konyaaltı", "Muratpaşa"};
    private String[] ilArtvin = {"Ardanuç", "Arhavi", "Merkez", "Borçka", "Hopa", "Şavşat", "Yusufeli", "Murgul"};
    private String[] ilAydın = {"Bozdoğan", "Çine", "Germencik", "Karacasu", "Koçarlı", "Kuşadası", "Kuyucak", "Nazilli", "Söke", "Yenipazar", "Buharkent", "İncirliova", "Karpuzlu", "Köşk", "Didim", "Efeler"};
    private String[] ilBalikesir = {"Ayvalık", "Balya", "Bandırma", "Bigadiç", "Burhaniye", "Dursunbey", "Edremit", "Erdek Gönen", "Havran", "İvrindi", "Kepsut", "Manyas", "Savaştepe", "Sındırgı", "Susurluk", "Marmara", "Gömeç", "Altıeylül", "Karesi"};
    private String[] ilBilecik = {"Merkez", "Bozüyük", "Gölpazarı", "Osmaneli", "Pazaryeri", "Söğüt", "Yenipazar", "İnhisar"};
    private String[] ilBingöl = {"Merkez", "Genç", "Karlıova", "Kiğı", "Solhan", "Adaklı", "Yayladere", "Yedisu"};
    private String[] ilBitlis = {"Adilcevaz", "Ahlat", "Merkez", "Hizan", "Mutki", "Tatvan", "Güroymak"};
    private String[] ilBolu = {"Merkez", "Gerede", "Göynük", "Kıbrıscık", "Mengen", "Mudurnu", "Seben", "Dörtdivan", "Yeniçağa"};
    private String[] ilBurdur = {"Ağlasun", "Bucak", "Merkez", "Gölhisar", "Tefenni", "Yeşilova", "Karamanlı", "Kemer", "Altınyayla", "Çavdır", "Çeltikçi"};
    private String[] ilBursa = {"Gemlik", "İnegöl", "İznik", "Karacabey", "Keles", "Mudanya", "Mustafakemalpaşa", "Orhaneli", "Orhangazi", "Yenişehir", "Büyükorhan", "Harmancık", "Nilüfer", "Osmangazi", "Yıldırım", "Gürsu", "Kestel"};
    private String[] ilÇanakkale = {"Ayvacık", "Bayramiç", "Biga", "Bozcaada", "Çan", "Merkez", "Eceabat", "Ezine", "Gelibolu", "Gökçeada", "Lapseki", "Yenice"};
    private String[] ilÇankırı = {"Merkez", "Çerkeş", "Eldivan", "Ilgaz", "Kurşunlu", "Orta", "Şabanözü", "Yapraklı", "Atkaracalar", "Kızılırmak", "Bayramören", "Korgun"};
    private String[] ilÇorum = {"Alaca", "Bayat", "Merkez", "İskilip", "Kargı", "Mecitözü", "Ortaköy", "Osmancık", "Sungurlu", "Boğazkale", "Uğurludağ", "Dodurga", "Laçin", "Oğuzlar"};
    private String[] ilDenizli = {"Çal", "Çameli", "Çardak", "Çivril", "Güney", "Kale / Denizli", "Sarayköy", "Tavas", "Babadağ", "Bekilli", "Honaz", "Serinhisar", "Pamukkale", "Baklan", "Beyağaç", "Bozkurt / Denizli", "Merkezefendi"};
    private String[] ilDiyarbakır = {"Çermik", "Çınar", "Çüngüş", "Dicle", "Ergani", "Hani", "Hazro", "Kulp", "Lice", "Silvan", "Eğil", "Kocaköy", "Bağlar", "Kayapınar", "Sur", "Yenişehir / Diyarbakır"};
    private String[] ilEdirne = {"Merkez", "Enez", "Havsa", "İpsala", "Keşan", "Lalapaşa", "Meriç", "Uzunköprü", "Süloğlu"};
    private String[] ilElazığ = {"Ağın", "Baskil", "Elazığ Merkez", "Karakoçan", "Keban", "Maden", "Palu", "Sivrice", "Arıcak", "Kovancılar", "Alacakaya"};
    private String[] ilErzincan = {"Çayırlı", "Erzincan Merkez", "İliç", "Kemah", "Kemaliye", "Refahiye", "Tercan", "Üzümlü", "Otlukbeli"};
    private String[] ilErzurum = {"Aşkale", "Çat", "Hınıs", "Horasan", "İspir", "Karayazı", "Narman", "Oltu", "Olur", "Pasinler", "Şenkaya", "Tekman", "Tortum", "Karaçoban", "Uzundere", "Pazaryolu", "Aziziye", "Köprüköy", "Palandöken", "Yakutiye"};
    private String[] ilEskişehir = {"Çifteler", "Mahmudiye", "Mihalıççık", "Sarıcakaya", "Seyitgazi", "Sivrihisar", "Alpu", "Beylikova", "İnönü", "Günyüzü", "Han", "Mihalgazi", "Odunpazarı", "Tepebaşı"};
    private String[] ilGaziantep = {"Araban", "İslahiye", "Nizip", "Oğuzeli", "Yavuzeli", "Şahinbey", "Şehitkamil", "Karkamış", "Nurdağı"};
    private String[] ilGiresun = {"Alucra", "Bulancak", "Dereli", "Espiye", "Eynesil", "Giresun Merkez", "Görele", "Keşap", "Şebinkarahisar", "Tirebolu", "Piraziz", "Yağlıdere", "Çamoluk", "Çanakçı", "Doğankent", "Güce"};
    private String[] ilGümüşhane = {"Merkez", "Kelkit", "Şiran", "Torul", "Köse", "Kürtün"};
    private String[] ilHakkari = {"Çukurca", "Merkez", "Şemdinli", "Yüksekova"};
    private String[] ilHatay = {"Altınözü", "Dörtyol", "Hassa", "İskenderun", "Kırıkhan", "Reyhanlı", "Samandağ", "Yayladağı", "Erzin", "Belen", "Kumlu", "Antakya", "Arsuz", "Defne", "Payas"};
    private String[] ilIsparta = {"Atabey", "Eğirdir", "Gelendost", "Merkez", "Keçiborlu", "Senirkent", "Sütçüler", "Şarkikaraağaç", "Uluborlu", "Yalvaç", "Aksu", "Gönen", "Yenişarbademli"};
    private String[] ilMersin = {"Anamur", "Erdemli", "Gülnar", "Mut", "Silifke", "Tarsus", "Aydıncık / Mersin", "Bozyazı", "Çamlıyayla", "Akdeniz", "Mezitli", "Toroslar", "Yenişehir / Mersin"};
    private String[] ilİstanbul = {"Adalar", "Bakırköy", "Beşiktaş", "Beykoz", "Beyoğlu", "Çatalca", "Eminönü", "Eyüp", "Fatih", "Gaziosmanpaşa", "Kadıköy", "Kartal", "Sarıyer", "Silivri", "Şile", "Şişli", "Üsküdar", "Zeytinburnu", "Büyükçekmece", "Kağıthane", "Küçükçekmece", "Pendik", "Ümraniye", "Bayrampaşa", "Avcılar", "Bağcılar", "Bahçelievler", "Güngören", "Maltepe", "Sultanbeyli", "Tuzla", "Esenler", "Arnavutköy", "Ataşehir", "Başakşehir", "Beylikdüzü", "Çekmeköy", "Esenyurt", "Sancaktepe", "Sultangazi"};
    private String[] ilİzmir = {"Aliağa", "Bayındır", "Bergama", "Bornova", "Çeşme", "Dikili", "Foça", "Karaburun", "Karşıyaka", "Kemalpaşa / İzmir", "Kınık", "Kiraz", "Menemen", "Ödemiş", "Seferihisar", "Selçuk", "Tire", "Torbalı", "Urla", "Beydağ", "Buca", "Konak", "Menderes", "Balçova", "Çiğli", "Gaziemir", "Narlıdere", "Güzelbahçe", "Bayraklı", "Karabağlar"};
    private String[] ilKars = {"Arpaçay", "Digor", "Kağızman", "Kars Merkez", "Sarıkamış", "Selim", "Susuz", "Akyaka"};
    private String[] ilKastamonu = {"Abana", "Araç", "Azdavay", "Bozkurt / Kastamonu", "Cide", "Çatalzeytin", "Daday", "Devrekani", "İnebolu", "Kastamonu Merkez", "Küre", "Taşköprü", "Tosya", "İhsangazi", "Pınarbaşı / Kastamonu", "Şenpazar", "Ağlı", "Doğanyurt", "Hanönü", "Seydiler"};
    private String[] ilKayseri = {"Bünyan", "Develi", "Felahiye", "İncesu", "Pınarbaşı / Kayseri", "Sarıoğlan", "Sarız", "Tomarza", "Yahyalı", "Yeşilhisar", "Akkışla", "Talas", "Kocasinan", "Melikgazi", "Hacılar", "Özvatan"};
    private String[] ilKırklareli = {"Babaeski", "Demirköy", "Kırklareli Merkez", "Kofçaz", "Lüleburgaz", "Pehlivanköy", "Pınarhisar", "Vize"};
    private String[] ilKırşehir = {"Çiçekdağı", "Kaman", "Kırşehir Merkez", "Mucur", "Akpınar", "Akçakent", "Boztepe"};
    private String[] ilKocaeli = {"Gebze", "Gölcük", "Kandıra", "Karamürsel", "Kocaeli Merkez", "Körfez", "Derince", "Başiskele", "Çayırova", "Darıca", "Dilovası", "İzmit", "Kartepe"};
    private String[] ilKonya = {"Akşehir", "Beyşehir", "Bozkır", "Cihanbeyli", "Çumra", "Doğanhisar", "Ereğli / Konya", "Hadim", "Ilgın", "Kadınhanı", "Karapınar", "Kulu", "Sarayönü", "Seydişehir", "Yunak", "Akören", "Altınekin", "Derebucak", "Hüyük", "Karatay", "Meram", "Selçuklu", "Taşkent", "Ahırlı", "Çeltik", "Derbent", "Emirgazi", "Güneysınır", "Halkapınar", "Tuzlukçu", "Yalıhüyük"};
    private String[] ilKütahya = {"Altıntaş", "Domaniç", "Emet", "Gediz", "Kütahya Merkez", "Simav", "Tavşanlı", "Aslanapa", "Dumlupınar", "Hisarcık", "Şaphane", "Çavdarhisar", "Pazarlar"};
    private String[] ilMalatya = {"Akçadağ", "Arapgir", "Arguvan", "Darende", "Doğanşehir", "Hekimhan", "Pütürge", "Yeşilyurt / Malatya", "Battalgazi", "Doğanyol", "Kale / Malatya", "Kuluncak", "Yazıhan"};
    private String[] ilManisa = {"Akhisar", "Alaşehir", "Demirci", "Gördes", "Kırkağaç", "Kula", "Manisa Merkez", "Salihli", "Sarıgöl", "Saruhanlı", "Selendi", "Soma", "Turgutlu", "Ahmetli", "Gölmarmara", "Köprübaşı / Manisa", "Şehzadeler", "Yunusemre"};
    private String[] ilKahramanmaraş = {"Afşin", "Andırın", "Elbistan", "Göksun", "Pazarcık", "Türkoğlu", "Çağlayancerit", "Ekinözü", "Nurhak", "Dulkadiroğlu", "Onikişubat"};
    private String[] ilMardin = {"Derik", "Kızıltepe", "Mazıdağı", "Midyat", "Nusaybin", "Ömerli", "Savur", "Dargeçit", "Yeşilli", "Artuklu"};
    private String[] ilMuğla = {"Bodrum", "Datça", "Fethiye", "Köyceğiz", "Marmaris", "Milas", "Ula", "Yatağan", "Dalaman", "Ortaca", "Kavaklıdere", "Menteşe", "Seydikemer"};
    private String[] ilMuş = {"Bulanık", "Malazgirt", "Muş Merkez", "Varto", "Hasköy", "Korkut"};
    private String[] ilNevşehir = {"Avanos", "Derinkuyu", "Gülşehir", "Hacıbektaş", "Kozaklı", "Nevşehir Merkez", "Ürgüp", "Acıgöl"};
    private String[] ilNiğde = {"Bor", "Çamardı", "Niğde Merkez", "Ulukışla", "Altunhisar", "Çiftlik"};
    private String[] ilOrdu = {"Akkuş", "Aybastı", "Fatsa", "Gölköy", "Korgan", "Kumru", "Mesudiye", "Perşembe", "Ulubey / Ordu", "Ünye", "Gülyalı", "Gürgentepe", "Çamaş", "Çatalpınar", "Çaybaşı", "İkizce", "Kabadüz", "Kabataş", "Altınordu"};
    private String[] ilRize = {"Ardeşen", "Çamlıhemşin", "Çayeli", "Fındıklı", "İkizdere", "Kalkandere", "Pazar / Rize", "Rize Merkez", "Güneysu", "Derepazarı", "Hemşin", "İyidere"};
    private String[] ilSakarya = {"Akyazı", "Geyve", "Hendek", "Karasu", "Kaynarca", "Sapanca", "Kocaali", "Pamukova", "Taraklı", "Ferizli", "Karapürçek", "Söğütlü", "Adapazarı", "Arifiye", "Erenler", "Serdivan"};
    private String[] ilSamsun = {"Alaçam", "Bafra", "Çarşamba", "Havza", "Kavak", "Ladik", "Terme", "Vezirköprü", "Asarcık", "19 Mayıs", "Salıpazarı", "Tekkeköy", "Ayvacık / Samsun", "Yakakent", "Atakum", "Canik", "İlkadım"};
    private String[] ilSiirt = {"Baykan", "Eruh", "Kurtalan", "Pervari", "Siirt Merkez", "Şirvan", "Tillo"};
    private String[] ilSinop = {"Ayancık", "Boyabat", "Durağan", "Erfelek", "Gerze", "Sinop Merkez", "Türkeli", "Dikmen", "Saraydüzü"};
    private String[] ilSivas = {"Divriği", "Gemerek", "Gürün", "Hafik", "İmranlı", "Kangal", "Koyulhisar", "Sivas Merkez", "Suşehri", "Şarkışla", "Yıldızeli", "Zara", "Akıncılar", "Altınyayla / Sivas", "Doğanşar", "Gölova", "Ulaş"};
    private String[] ilTekirdağ = {"Çerkezköy", "Çorlu", "Hayrabolu", "Malkara", "Muratlı", "Saray / Tekirdağ", "Şarköy", "Marmaraereğlisi", "Ergene", "Kapaklı", "Süleymanpaşa"};
    private String[] ilTokat = {"Almus", "Artova", "Erbaa", "Niksar", "Reşadiye", "Tokat Merkez", "Turhal", "Zile", "Pazar / Tokat", "Yeşilyurt / Tokat", "Başçiftlik", "Sulusaray"};
    private String[] ilTrabzon = {"Araklı", "Arsin", "Çaykara", "Maçka", "Of", "Sürmene", "Tonya", "Vakfıkebir", "Yomra", "Beşikdüzü", "Şalpazarı", "Çarşıbaşı", "Dernekpazarı", "Düzköy", "Hayrat", "Köprübaşı / Trabzon", "Ortahisar"};
    private String[] ilTunceli = {"Çemişgezek", "Hozat", "Mazgirt", "Nazımiye", "Ovacık / Tunceli", "Pertek", "Pülümür", "Tunceli Merkez"};
    private String[] ilŞanlıurfa = {"Akçakale", "Birecik", "Bozova", "Ceylanpınar", "Halfeti", "Hilvan", "Siverek", "Suruç", "Viranşehir", "Harran", "Eyyübiye", "Haliliye", "Karaköprü"};
    private String[] ilUşak = {"Banaz", "Eşme", "Karahallı", "Sivaslı", "Ulubey / Uşak", "Uşak Merkez"};
    private String[] ilVan = {"Başkale", "Çatak", "Erciş", "Gevaş", "Gürpınar", "Muradiye", "Özalp", "Bahçesaray", "Çaldıran", "Edremit / Van", "Saray / Van", "İpekyolu", "Tuşba"};
    private String[] ilYozgat = {"Akdağmadeni", "Boğazlıyan", "Çayıralan", "Çekerek", "Sarıkaya", "Sorgun", "Şefaatli", "Yerköy", "Yozgat Merkez", "Aydıncık / Yozgat", "Çandır", "Kadışehri", "Saraykent", "Yenifakılı"};
    private String[] ilZonguldak = {"Çaycuma", "Devrek", "Ereğli / Zonguldak", "Zonguldak Merkez", "Alaplı", "Gökçebey", "Kilimli", "Kozlu"};
    private String[] ilAksaray = {"Merkez", "Ortaköy / Aksaray", "Ağaçören", "Güzelyurt", "Sarıyahşi", "Eskil", "Gülağaç"};
    private String[] ilBayburt = {"Merkez", "Aydıntepe", "Demirözü"};
    private String[] ilKaraman = {"Ermenek", "Karaman Merkez", "Ayrancı", "Kazımkarabekir", "Başyayla", "Sarıveliler"};
    private String[] ilKırıkkale = {"Delice", "Keskin", "Kırıkkale Merkez", "Sulakyurt", "Bahşili", "Balışeyh", "Çelebi", "Karakeçili", "Yahşihan"};
    private String[] ilBatman = {"Merkez", "Beşiri", "Gercüş", "Kozluk", "Sason", "Hasankeyf"};
    private String[] ilŞırnak = {"Beytüşşebap", "Cizre", "İdil", "Silopi", "Şırnak Merkez", "Uludere", "Güçlükonak"};
    private String[] ilBartın = {"Merkez", "Kurucaşile", "Ulus", "Amasra"};
    private String[] ilArdahan = {"Merkez", "Çıldır", "Göle", "Hanak", "Posof", "Damal"};
    private String[] ilIğdır = {"Aralık", "Iğdır Merkez", "Tuzluca", "Karakoyunlu"};
    private String[] ilYalova = {"Merkez", "Altınova", "Armutlu", "Çınarcık", "Çiftlikköy", "Termal"};
    private String[] ilKarabük = {"Eflani", "Eskipazar", "Karabük Merkez", "Ovacık / Karabük", "Safranbolu", "Yenice / Karabük"};
    private String[] ilKilis = {"Merkez", "Elbeyli", "Musabeyli", "Polateli"};
    private String[] ilOsmaniye = {"Bahçe", "Kadirli", "Osmaniye Merkez", "Düziçi", "Hasanbeyli", "Sumbas", "Toprakkale"};
    private String[] ilDüzce = {"Akçakoca", "Düzce Merkez", "Yığılca", "Cumayeri", "Gölyaka", "Çilimli", "Gümüşova", "Kaynaşlı"};              /////spin ready for use
    private ArrayAdapter<String> dataAdapterForIller;
    private ArrayAdapter<String> dataAdapterForIlceler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berberbilgiler);
        adres = (EditText) findViewById(R.id.adrestarifi);
        okey = (Button) findViewById(R.id.okey);
        ilin = (Spinner) findViewById(R.id.spinil);
        ilcenin = (Spinner) findViewById(R.id.spinilce);
        dataAdapterForIller = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, iller);          ////tipini yarat spinner
        dataAdapterForIlceler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ilAdana);
        dataAdapterForIller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);                          //görünüm kazandır spinnerlara
        dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ilin.setAdapter(dataAdapterForIller);
        ilcenin.setAdapter(dataAdapterForIlceler);
        ilin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getSelectedItem().toString().equals(iller[0])){
                    dataAdapterForIlceler = new ArrayAdapter<String>(Berberbilgiler.this, android.R.layout.simple_spinner_item,ilAdana);
                }
                else if(parent.getSelectedItem().toString().equals(iller[1])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilAdıyaman);
                }
                else if(parent.getSelectedItem().toString().equals(iller[2])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilAfyonkarahisar);
                }
                else if(parent.getSelectedItem().toString().equals(iller[3])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilAğrı);
                }
                else if(parent.getSelectedItem().toString().equals(iller[4])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilAmasya);
                }
                else if(parent.getSelectedItem().toString().equals(iller[5])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilAnkara);
                }
                else if(parent.getSelectedItem().toString().equals(iller[6])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilAntalya);
                }
                else if(parent.getSelectedItem().toString().equals(iller[7])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilArtvin);
                }
                else if(parent.getSelectedItem().toString().equals(iller[8])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilAydın);
                }
                else if(parent.getSelectedItem().toString().equals(iller[9])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilBalikesir);
                }
                else if(parent.getSelectedItem().toString().equals(iller[10])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilBilecik);
                }
                else if(parent.getSelectedItem().toString().equals(iller[11])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilBingöl);
                }
                else if(parent.getSelectedItem().toString().equals(iller[12])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilBitlis);
                }
                else if(parent.getSelectedItem().toString().equals(iller[13])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilBolu);
                }
                else if(parent.getSelectedItem().toString().equals(iller[14])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilBurdur);
                }
                else if(parent.getSelectedItem().toString().equals(iller[15])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilBursa);
                }
                else if(parent.getSelectedItem().toString().equals(iller[16])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilÇanakkale);
                }
                else if(parent.getSelectedItem().toString().equals(iller[17])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilÇankırı);
                }
                else if(parent.getSelectedItem().toString().equals(iller[18])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilÇorum);
                }
                else if(parent.getSelectedItem().toString().equals(iller[19])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilDenizli);
                }
                else if(parent.getSelectedItem().toString().equals(iller[20])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilDiyarbakır);
                }
                else if(parent.getSelectedItem().toString().equals(iller[21])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilEdirne);
                }
                else if(parent.getSelectedItem().toString().equals(iller[22])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilElazığ);
                }
                else if(parent.getSelectedItem().toString().equals(iller[23])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilErzincan);
                }
                else if(parent.getSelectedItem().toString().equals(iller[24])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilErzurum);
                }
                else if(parent.getSelectedItem().toString().equals(iller[25])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilEskişehir);
                }
                else if(parent.getSelectedItem().toString().equals(iller[26])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilGaziantep);
                }

                else if(parent.getSelectedItem().toString().equals(iller[27])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilGiresun);
                }
                else if(parent.getSelectedItem().toString().equals(iller[28])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilGümüşhane);
                }
                else if(parent.getSelectedItem().toString().equals(iller[29])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilHakkari);
                }
                else if(parent.getSelectedItem().toString().equals(iller[30])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilHatay);
                }
                else if(parent.getSelectedItem().toString().equals(iller[31])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilIsparta);
                }
                else if(parent.getSelectedItem().toString().equals(iller[32])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilMersin);
                }
                else if(parent.getSelectedItem().toString().equals(iller[33])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilİstanbul);
                }
                else if(parent.getSelectedItem().toString().equals(iller[34])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilİzmir);
                }
                else if(parent.getSelectedItem().toString().equals(iller[35])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilKars);
                }
                else if(parent.getSelectedItem().toString().equals(iller[36])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilKastamonu);
                }
                else if(parent.getSelectedItem().toString().equals(iller[37])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilKayseri);
                }
                else if(parent.getSelectedItem().toString().equals(iller[38])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilKırklareli);
                }
                else if(parent.getSelectedItem().toString().equals(iller[39])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilKırşehir);
                }
                else if(parent.getSelectedItem().toString().equals(iller[40])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilKocaeli);
                }
                else if(parent.getSelectedItem().toString().equals(iller[41])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilKonya);
                }
                else if(parent.getSelectedItem().toString().equals(iller[42])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilKütahya);
                }
                else if(parent.getSelectedItem().toString().equals(iller[43])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilMalatya);
                }
                else if(parent.getSelectedItem().toString().equals(iller[44])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilManisa);
                }
                else if(parent.getSelectedItem().toString().equals(iller[45])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilKahramanmaraş);
                }
                else if(parent.getSelectedItem().toString().equals(iller[46])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilMardin);
                }
                else if(parent.getSelectedItem().toString().equals(iller[47])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilMuğla);
                }
                else if(parent.getSelectedItem().toString().equals(iller[48])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilMuş);
                }
                else if(parent.getSelectedItem().toString().equals(iller[49])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilNevşehir);
                }
                else if(parent.getSelectedItem().toString().equals(iller[50])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilNiğde);
                }
                else if(parent.getSelectedItem().toString().equals(iller[51])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilOrdu);
                }
                else if(parent.getSelectedItem().toString().equals(iller[52])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilRize);
                }
                else if(parent.getSelectedItem().toString().equals(iller[53])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilSakarya);
                }
                else if(parent.getSelectedItem().toString().equals(iller[54])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilSamsun);
                }
                else if(parent.getSelectedItem().toString().equals(iller[55])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilSiirt);
                }
                else if(parent.getSelectedItem().toString().equals(iller[56])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilSinop);
                }
                else if(parent.getSelectedItem().toString().equals(iller[57])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilSivas);
                }
                else if(parent.getSelectedItem().toString().equals(iller[58])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilTekirdağ);
                }
                else if(parent.getSelectedItem().toString().equals(iller[59])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilTokat);
                }
                else if(parent.getSelectedItem().toString().equals(iller[60])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilTrabzon);
                }
                else if(parent.getSelectedItem().toString().equals(iller[61])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilTunceli);
                }
                else if(parent.getSelectedItem().toString().equals(iller[62])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilŞanlıurfa);
                }
                else if(parent.getSelectedItem().toString().equals(iller[63])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilUşak);
                }
                else if(parent.getSelectedItem().toString().equals(iller[64])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilVan);
                }
                else if(parent.getSelectedItem().toString().equals(iller[65])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilYozgat);
                }
                else if(parent.getSelectedItem().toString().equals(iller[66])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilZonguldak);
                }
                else if(parent.getSelectedItem().toString().equals(iller[67])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilAksaray);
                }
                else if(parent.getSelectedItem().toString().equals(iller[68])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilBayburt);
                }
                else if(parent.getSelectedItem().toString().equals(iller[69])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilKaraman);
                }
                else if(parent.getSelectedItem().toString().equals(iller[70])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilKırıkkale);
                }
                else if(parent.getSelectedItem().toString().equals(iller[71])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilBatman);
                }
                else if(parent.getSelectedItem().toString().equals(iller[72])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilŞırnak);
                }
                else if(parent.getSelectedItem().toString().equals(iller[73])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilBartın);
                }
                else if(parent.getSelectedItem().toString().equals(iller[74])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilArdahan);
                }
                else if(parent.getSelectedItem().toString().equals(iller[75])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilIğdır);
                }
                else if(parent.getSelectedItem().toString().equals(iller[76])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilYalova);
                }
                else if(parent.getSelectedItem().toString().equals(iller[77])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilKarabük);
                }
                else if(parent.getSelectedItem().toString().equals(iller[78])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilKilis);
                }
                else if(parent.getSelectedItem().toString().equals(iller[79])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilOsmaniye);
                }
                else if(parent.getSelectedItem().toString().equals(iller[80])){
                    dataAdapterForIlceler=new ArrayAdapter<String>(Berberbilgiler.this,android.R.layout.simple_spinner_item,ilDüzce);
                }
                dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                ilcenin.setAdapter(dataAdapterForIlceler);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ilcenin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        okey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tarif=adres.getText().toString();       //number 1
                if(tarif.isEmpty()){
                    Toast.makeText(Berberbilgiler.this,"Lütfen adres tarifini doldurun",Toast.LENGTH_LONG).show();

                }
                else{
                    Yapilanisekleme yapilan=new Yapilanisekleme();
                    CompanyAdres adres=new CompanyAdres();
                    String il=ilin.getSelectedItem().toString();
                    String ilceisim=ilcenin.getSelectedItem().toString();
                    String calisanisim=getIntent().getStringExtra("employename");    //number 2
                    String telno=getIntent().getStringExtra("phonenum");             //number 3
                    String mekanisim=getIntent().getStringExtra("compname");         //number 4
                 String uniqueId = firebaseUser.getUid();
                    adres.setAdres(tarif);
                    adres.setCalisanisim(calisanisim);
                    adres.setTelno(telno);
                    adres.setMekanisim(mekanisim);
                    adres.setIdesi(uniqueId);
                    yapilan.setIl(il);
                    yapilan.setIlce(ilceisim);
                    yapilan.setId(uniqueId);
                    myRef.child(il).child(ilceisim).child(uniqueId).setValue(adres);
                    String permisson="false";
                    mio.child(uniqueId).child("permisson").setValue(permisson);
                    Toast.makeText(Berberbilgiler.this,"Kayıt oluşturuldu",Toast.LENGTH_LONG).show();
                    Intent intenet=new Intent(Berberbilgiler.this,mekanarayuz.class);
                    startActivity(intenet);
                    finish();
                }
            }
        });

    }
}
