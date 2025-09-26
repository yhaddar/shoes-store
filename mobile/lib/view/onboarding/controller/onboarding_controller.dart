import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:shoes/setting/images.dart';
import 'package:shoes/setting/texts.dart';

import '../../authentication/ui/sign_in_view.dart';

class OnboardingController extends GetxController {
  static OnboardingController get instance => Get.find();

  late PageController pageController = PageController();

  List<Map<String, String>> screens = [
    {
      "image": Images.onboarding1,
      "title": Texts.onboardingText1
    },
    {
      "image": Images.onboarding2,
      "title": Texts.onboardingText2
    },
    {
      "image": Images.onboarding3,
      "title": Texts.onboardingText3
    }
  ];

  Rx<int> currentPage = 0.obs;

  void updatePageIndicator(int index)  {
    currentPage.value = index;
  }

  void nextPage(BuildContext context){
    if(currentPage.value < screens.length - 1){
      pageController.nextPage(duration: Duration(milliseconds: 500), curve: Curves.easeInOut);
    }else {
      Navigator.push(context, MaterialPageRoute(builder: (context) => SignInView()));
    }
  }

}
