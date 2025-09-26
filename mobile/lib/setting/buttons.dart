import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:shoes/setting/colors.dart';
import 'package:shoes/setting/texts.dart';

class Buttons {
  static ElevatedButton elevatedButton(String text, BuildContext context, VoidCallback method, {bool theme = false}) {
    return ElevatedButton(
        onPressed: method,
        style: ElevatedButton.styleFrom(
          elevation: 0,
          backgroundColor: Colors.transparent,
          shadowColor: Colors.transparent,
        ),
        child: Container(
          width: MediaQuery.of(context).size.width,
          padding: EdgeInsets.symmetric(vertical: 15),
          decoration: BoxDecoration(
            color: theme ? Theme.of(context).colorScheme.primary : Colors.black,
            borderRadius: BorderRadius.circular(10)
          ),
          child: Text(Texts.toFirstLetterUpperCase(text),
            textAlign: TextAlign.center,
            style: GoogleFonts.karla(
            textStyle: TextStyle(
              color: theme ? Theme.of(context).colorScheme.onBackground : CustomColors.textPrimaryDark,
              fontSize: text.length > 15 ? 16 : 18,
              fontWeight: FontWeight.w600
            )
          ),),
        )
    );
  }
}
