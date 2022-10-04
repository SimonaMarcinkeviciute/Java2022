import i18n from "i18next";
import {initReactI18next} from "react-i18next";
import en from '../i18n/transalations/en.json';
import lt from './transalations/lt.json'

i18n
    .use(initReactI18next)
    .init(
        {
            resources: {

                    en, lt

            },
            whiteList: ['en', 'lt'],
            lang: "en",
            fallbackLng: "en",
            interpolation: {
                escapeValue: false
            }
        }
    );

export default i18n;