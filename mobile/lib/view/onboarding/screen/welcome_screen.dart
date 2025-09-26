import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:shoes/view/onboarding/screen/onboarding_screen.dart';

import '../../../setting/buttons.dart';
import '../../../setting/colors.dart';
import '../../../setting/images.dart';
import '../../../setting/texts.dart';

class WelcomeScreen extends StatelessWidget {
  const WelcomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        width: MediaQuery.of(context).size.width,
        height: double.infinity,
        decoration: BoxDecoration(
          image: DecorationImage(
            image: NetworkImage(Images.welcomeShoes),
            fit: BoxFit.cover,
          ),
        ),
        child: Padding(
          padding: const EdgeInsets.only(bottom: 28.0, left: 18, right: 18),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.end,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                Texts.toFirstLetterUpperCase(Texts.welcomeText),
                style: GoogleFonts.nunito(
                  textStyle: TextStyle(
                    color: CustomColors.textPrimaryDark,
                    fontWeight: FontWeight.w600,
                    fontSize: 30,
                  ),
                ),
              ),
              Text(
                Texts.toFirstLetterUpperCase(Texts.brandName),
                style: GoogleFonts.ubuntu(
                  textStyle: TextStyle(
                    color: CustomColors.textPrimaryDark,
                    fontWeight: FontWeight.bold,
                    fontSize: 58,
                  ),
                ),
              ),

              Text(
                Texts.toFirstLetterUpperCase(Texts.welcomeDescription),
                textAlign: TextAlign.justify,
                style: GoogleFonts.anekTelugu(
                  textStyle: TextStyle(
                    color: CustomColors.textPrimaryDark,
                    fontWeight: FontWeight.w500,
                    fontSize: 14,
                  ),
                ),
              ),
              SizedBox(height: 10,),
              Buttons.elevatedButton(Texts.welcome, context, () {
                Navigator.push(context, MaterialPageRoute(builder: (context) => OnboardingScreen()));
              }),
            ],
          ),
        ),
      ),
    );
  }
}
