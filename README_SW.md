# ARB CALCULAT ATHEMS — Android project

Hii ni **project ya source**, si APK iliyokwisha jengwa. Workflow ya GitHub Actions imewekwa ili kujaribu kujenga APK ya debug.

## Jinsi ya kujenga APK kwa simu
1. Pakua ZIP hii na utoe (Extract) faili kwenye simu au kompyuta.
2. Fungua repository yako ya GitHub.
3. Pakia yaliyomo ndani ya folda iliyotolewa (si ZIP yenyewe). Hakikisha `app`, `.github`, `settings.gradle.kts`, `build.gradle.kts` na `gradle.properties` ziko kwenye mzizi wa repository.
4. Kwenye GitHub, fungua **Actions** → **Build ARB CALCULAT ATHEMS APK** → **Run workflow**.
5. Subiri job imalize. Ikifaulu, fungua run hiyo, nenda sehemu ya **Artifacts**, pakua `ARB-CALCULAT-ATHEMS-debug-apk`, kisha extract APK na usakinishe.

## Vipengele
- Calculator ya 1X2: Home / Draw / Away, mtaji, stake, payout, faida na ROI.
- OCR ya screenshot kupitia ML Kit.
- Ruhusa ya Android MediaProjection kwa live screen capture.
- Floating overlay inayopokea odds zilizotambuliwa na kuonyesha makadirio.

## Mipaka muhimu
- OCR ya live kwa sasa hutumia odds tatu za kwanza zinazofanana na muundo wa namba. **Haijathibitishwa kutambua lebo za Home/Draw/Away kwa uhakika**, kwa hiyo inaweza kuchukua namba zisizo sahihi. Hakiki odds kwa macho kabla ya kutumia hesabu.
- Hii haija-buildiwa au kujaribiwa kwenye kifaa halisi ndani ya mazingira haya. GitHub Actions ndiyo itathibitisha kama APK inajengwa.
- Baadhi ya betting apps huzuia screen capture. Android huonyesha ruhusa ya capture; lazima ukubali wewe mwenyewe.
- Faida ni makadirio kabla ya ada, kodi, limits, mabadiliko ya odds na kukataliwa kwa dau. Hakuna faida iliyohakikishwa.
