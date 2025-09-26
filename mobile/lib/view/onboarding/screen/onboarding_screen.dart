import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:smooth_page_indicator/smooth_page_indicator.dart';
import '../../../setting/buttons.dart';
import '../controller/onboarding_controller.dart';
import '../widget/onboarding_widget.dart';

class OnboardingScreen extends StatelessWidget {
  const OnboardingScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final OnboardingController onboardingController = Get.put(
      OnboardingController(),
    );
    return Scaffold(
      body: Column(
        children: [
          Expanded(
            child: PageView.builder(
              controller: onboardingController.pageController,
              onPageChanged: (index) =>
                  onboardingController.updatePageIndicator(index),
              itemCount: onboardingController.screens.length,
              itemBuilder: (BuildContext context, int index) =>
                  OnboardingWidget(
                    title: onboardingController.screens[index]["title"]!,
                    image: onboardingController.screens[index]["image"]!,
                  ),
            ),
          ),
          Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              SmoothPageIndicator(
                controller: onboardingController.pageController,
                count: 3,
                effect: ExpandingDotsEffect(
                  activeDotColor: Theme.of(context).colorScheme.primary,
                  dotWidth: 12,
                  dotHeight: 10,
                ),
              ),
              SizedBox(height: 20),
              Obx(
                () => Buttons.elevatedButton(
                  onboardingController.currentPage == 2
                      ? "get started"
                      : "next",
                  context,
                  () => OnboardingController.instance.nextPage(context),
                  theme: true,
                ),
              ),
              SizedBox(height: 10),
            ],
          ),
        ],
      ),
    );
  }
}
