
import 'package:flutter/material.dart';

class Images {

  static bool ThemeMode(BuildContext context){
    return Theme.of(context).brightness == Brightness.light;

}

  static String welcomeShoes = "https://i.pinimg.com/736x/10/49/b8/1049b89722f31586c3977a5c792f4184.jpg";

  static String onboarding1 = "https://i.pinimg.com/736x/d3/b7/58/d3b758c1b7fd42352cae134110dd7b62.jpg";
  static String onboarding2 = "https://i.pinimg.com/736x/c1/94/51/c1945103456d1139efca580ef48c2a03.jpg";
  static String onboarding3 = "https://i.pinimg.com/1200x/a7/e3/b8/a7e3b84acae6091c040c06a937cdbad9.jpg";

  static String loginImage = "assets/images/authentication/login.png";
  static String google = "assets/images/authentication/google.png";
  static String facebook = "assets/images/authentication/facebook.png";

  static String apple(BuildContext context) {
    final theme = ThemeMode(context);
    return "assets/images/authentication/${theme ? "apple" : "apple_dark"}.png";
  }

  static String logo(BuildContext context){
    final theme = ThemeMode(context);
    return "assets/images/splash/${theme ? "shoes_white" : "shoes_dark"}.png";
  }

}