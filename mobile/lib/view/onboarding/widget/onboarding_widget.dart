import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

import '../../../setting/texts.dart';

class OnboardingWidget extends StatelessWidget {
  final String title;
  final String image;

  const OnboardingWidget({required this.title, required this.image, super.key});

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        SizedBox(
          width: MediaQuery.of(context).size.width,
          height: MediaQuery.of(context).size.height * 0.6,
          child: Image.network(image, fit: BoxFit.cover,),
        ),

        Expanded(
          child: Padding(
            padding: const EdgeInsets.symmetric(vertical: 12.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.center,
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 8.0),
                  child: Text(
                    Texts.toFirstLetterUpperCase(title),
                    textAlign: TextAlign.center,
                    style: GoogleFonts.karla(
                        fontSize: 28,
                        fontWeight: FontWeight.w600,
                        color: Theme.of(context).colorScheme.background
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ],
    );
  }
}
