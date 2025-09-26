class Texts {
  static String welcomeText = "welcome to";
  static String brandName = "shoes";
  static String welcomeDescription = "welcome to our world of shoes — where comfort meets style! Discover the perfect pair designed to keep you moving with confidence every step of the way.";
  static String welcome = "welcome";
  static String onboardingText1 = "we provide high quality products just for you";
  static String onboardingText2 = "your satisfaction is our number one priority";
  static String onboardingText3 = "let's fulfill your fashion needs with ${toFirstLetterUpperCase(brandName)} right now!";
  static String googleText = "continue with google";
  static String facebookText = "continue with facebook";
  static String appleText = "continue with apple";
  static String dontHaveAccount = "don't have an account ?";
  static String signUp = "sign up";
  static String createAccout = "create your account";
  static String email = "enter your email";
  static String password = "enter your password";

  static String toFirstLetterUpperCase(String text) => text[0].toUpperCase() + text.substring(1).toLowerCase();

  static String toCapitalize(String text) {
    List<String> textToList = text.split(" ");
    String result = textToList.map(toFirstLetterUpperCase).join(" ");

    return result;
  }

}