import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:shoes/setting/images.dart';
import 'package:shoes/setting/texts.dart';

class Oauth21Widget extends StatelessWidget {
  final String image;
  final String title;
  final VoidCallback? redirect;

  const Oauth21Widget({required this.image, required this.title, this.redirect, super.key});

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: redirect,
      child: Container(
        width: MediaQuery.of(context).size.width,
        padding: EdgeInsets.symmetric(vertical: 10),
        margin: EdgeInsets.symmetric(vertical: 4),
        decoration: BoxDecoration(
          border: Border.all(
            color: Theme.of(context).colorScheme.outline,
            width: 2
          ),
          borderRadius: BorderRadius.circular(10)
        ),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            SizedBox(
              width: 32,
              height: 32,
              child: Image.asset(image),
            ),
            SizedBox(width: 10,),
            Text(Texts.toCapitalize(title), style: GoogleFonts.karla(
              textStyle: TextStyle(
                color: Theme.of(context).colorScheme.background,
                fontWeight: FontWeight.w600,
                fontSize: 16
              )
            ),)
          ],
        ),
      ),
    );
  }
}
