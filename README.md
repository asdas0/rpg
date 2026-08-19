# RPG Mod (Forge 1.20.1)

Bu proje sana şunları veriyor:

## Eşyalar
- **Magic Sword** – vurduğunda düşmana Zayıflık efekti verir
- **Mana Crystal** – crafting materyali (amethyst + ender pearl'den yapılır)
- **Shadow Essence** – crafting materyali (kömür + mürekkep + barut'tan yapılır)
- **Greater Healing Potion** – sağ tıkla 5 kalp can doldurur
- **Shadow Stalker Spawn Egg** – yaratıcı modda mob'u elle doğurmak için

## Mob
- **Void Wraith** – uçan, tamamen özgün AI'a sahip gölge yaratığı.
- **Crystal Golem** – yavaş ama çok canlı, çok hasarlı kristal dev.
- **+32 yeni canlı** (20 düşman, 12 dost) — aşağıya bak.

### Yeni eklenen 32 canlı (RPG Mod v2)
Hepsi Overworld'de (`#minecraft:is_overworld`) doğal olarak, her biyomda
kendiliğinden doğar (`data/rpgmod/forge/biome_modifier/`). Görünümleri
birbirinden farklı olsun diye her biri farklı bir vanilla model iskeleti
(zombi, örümcek, kurt, inek, arı, tavşan, kaplumbağa, ifrit, balçık,
papağan) üzerine kendi özgün dokusuyla (texture) giydirilmiştir; can,
hız, hasar ve zırh değerleri hepsinde farklıdır.

**Düşman canlılar (20):** Ember Ghoul, Frost Fiend, Bog Zombie,
Shadow Stalker, Wither Acolyte, Cursed Knight, Bone Reaver,
Corrupted Piglin, Obsidian Golem, Venom Spider, Plague Rat, Rot Hound,
Swamp Troll, Crimson Boar, Giant Wasp, Night Owl Stalker, Deep Crawler,
Storm Wraith, Molten Imp, Chaos Slime.

**Dost canlılar (12):** Woodland Sprite, Guardian Spirit, Highland Goat,
Gentle Yak, Sky Fawn, Prairie Hare, Snow Fox Cub, River Otter,
Coral Turtle, Ancient Tortoise, Luminous Bee, Star Parrot.

Hepsinin doğurma yumurtası "RPG Mod" yaratıcı sekmesinde mevcuttur, örn.
`/summon rpgmod:ember_ghoul` ya da `/summon rpgmod:sky_fawn`.

> Not: Bu 32 canlı, elle yazılmış tamamen yeni 3B modeller yerine (zaman
> kazanmak ve derleme hatası riskini azaltmak için) vanilla Minecraft'ın
> hazır model iskeletlerini yeniden kullanıp üstüne kendi renk/doku
> düzenini basıyor — yani gövde şekli bazı gruplarda ortak ama renk,
> boyut, davranış ve istatistikler her birinde benzersiz. Daha da özgün
> 3B modeller istersen (VoidWraithModel/CrystalGolemModel gibi elle
> yazılmış), Blockbench ile ayrı ayrı model dosyaları hazırlayıp aynı
> `client/model` + `client/renderer` deseniyle ekleyebilirsin.

## Craft Tarifleri
- `Diamond Sword + Mana Crystal + Shadow Essence` → `Magic Sword`
- `4x Amethyst Shard + Ender Pearl` (artı şeklinde) → `2x Mana Crystal`
- `Coal + Ink Sac + Gunpowder` → `2x Shadow Essence`

---

## Nasıl çalıştırılır (ÖNEMLİ)

Bu proje `gradlew` (Gradle Wrapper) dosyalarını İÇERMİYOR çünkü onlar binary
dosyalar ve internet erişimi olmadan indiremedim. Kurulum için:

1. [Forge MDK](https://files.minecraftforge.net/) sitesinden **1.20.1 - 47.2.0**
   sürümünü indir (bu sana `gradlew`, `gradlew.bat`, `gradle/` klasörünü verir).
2. İndirdiğin MDK'nın `gradlew`, `gradlew.bat` ve `gradle/` klasörünü, bu projenin
   kök dizinine (build.gradle ile aynı yere) kopyala.
3. Bu projeyi **IntelliJ IDEA**'da aç (`build.gradle` dosyasını seç, "Open as Project").
4. Gradle senkronize olsun (ilk seferde bağımlılıkları indirir, biraz sürer).
5. Sağ üstteki Gradle panelinden `Tasks > forgegradle runs > runClient` çalıştır,
   ya da terminalde: `./gradlew runClient` (Mac/Linux) veya `gradlew.bat runClient` (Windows)
6. Oyun açılınca yaratıcı modda "RPG Mod" sekmesinde eşyaları göreceksin.
   Yaratma komutu: `/summon rpgmod:shadow_stalker`

## Kendi görsellerini eklemek istersen
Şu an eşyalarda basit placeholder (yer tutucu) renkli kareler var, mob da zombi
texture'ının üstüne boyanmış placeholder kullanıyor. Gerçek görsel için:

- **Eşyalar**: 16x16 px PNG yap, şu klasöre koy ve aynı isimle kaydet:
  `src/main/resources/assets/rpgmod/textures/item/magic_sword.png`
- **Mob**: 64x64 px PNG (zombi UV şablonuna göre), buraya koy:
  `src/main/resources/assets/rpgmod/textures/entity/shadow_stalker.png`

Görsel yapmak için [Blockbench](https://www.blockbench.net/) (mob modeli/animasyon
için) veya herhangi bir pixel-art editörü (item texture için) kullanabilirsin.

## Yeni eşya/mob eklemek istersen
- Yeni eşya: `init/ModItems.java` içine yeni bir `RegistryObject<Item>` satırı ekle,
  `models/item/` altına model json'ı ve `textures/item/` altına png koy.
- Yeni mob: `entity/` altına yeni bir sınıf yaz (ShadowStalkerEntity'yi örnek al),
  `init/ModEntities.java`'ya kaydını ekle, `client/ClientModEvents.java`'da
  attribute ve renderer bağlantısını yap.

Sorun yaşarsan hatanın tam metnini bana yapıştır, birlikte çözeriz.
