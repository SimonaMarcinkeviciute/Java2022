import i18n from "i18next";
import {initReactI18next} from "react-i18next";
import en from './translations/en.json'
//pirmine translate konfiguracija
//suteikia galimybe panaudoti hooks initReacti18Next
//po init visa cofiguracija su vertimais
i18n
    .use(initReactI18next)
    .init(
        {
            resources: {
                en
            },
            lang: "en",
            fallbackLng: "en",
            interpolation: {
                escapeValue: false
            }
        }
    );

export default i18n;