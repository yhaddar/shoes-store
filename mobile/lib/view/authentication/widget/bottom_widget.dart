import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

import '../../../setting/texts.dart';

class BottomWidget extends StatelessWidget {
  final String title;
  final String text;
  final VoidCallback redirect;

  const BottomWidget({required this.title, required this.text, required this.redirect, super.key});

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          Texts.toFirstLetterUpperCase(title),
          style: GoogleFonts.nunito(
            color: Theme.of(context).colorScheme.background.withOpacity(0.7),
            fontSize: 15,
          ),
        ),
        SizedBox(width: 10),
        InkWell(
          onTap: redirect,
          child: Text(
            Texts.toFirstLetterUpperCase(text),
            style: GoogleFonts.nunito(
                color: Theme.of(context).colorScheme.background,
                fontSize: 15,
                fontWeight: FontWeight.w700
            ),
          ),
        )
      ],
    );
  }
}
