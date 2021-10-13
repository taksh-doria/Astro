package com.takshdoria.astro;
//astro class containing method to calculate zodiac sign
public class AstroCalc {
    public String getZodiacSign(int date,int month)
    {
        String sign = "";
        if (month == 1) {
            if (date < 20)
                sign = "capricorn";
            else
                sign = "Aquarius";
        }
        else if (month == 2) {
            if (date < 19)
                sign = "Aquarius";
            else
                sign = "Pisces";
        }
        else if(month == 3) {
            if (date < 21)
                sign = "Pisces";
            else
                sign = "Aries";
        }
        else if (month == 4) {
            if (date < 20)
                sign = "Aries";
            else
                sign = "Taurus";
        }
        else if (month == 5) {
            if (date < 21)
                sign = "Taurus";
            else
                sign = "Gemini";
        }
        else if( month == 6) {
            if (date < 21)
                sign = "Gemini";
            else
                sign = "Cancer";
        }
        else if (month == 7) {
            if (date < 23)
                sign = "Cancer";
            else
                sign = "Leo";
        }
        else if( month == 8) {
            if (date < 23)
                sign = "Leo";
            else
                sign = "Virgo";
        }
        else if (month == 9) {
            if (date < 23)
                sign = "Virgo";
            else
                sign = "Libra";
        }
        else if (month == 10) {
            if (date < 23)
                sign = "Libra";
            else
                sign = "Scorpio";
        }
        else if (month == 11) {
            if (date < 22)
                sign = "scorpio";
            else
                sign = "Sagittarius";
        }
        else if (month == 12) {
            if (date < 22)
                sign = "Sagittarius";
            else
                sign ="Capricorn";
        }
        return sign;
    }
    
}
