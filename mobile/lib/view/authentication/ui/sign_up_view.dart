import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:iconsax/iconsax.dart';
import 'package:shoes/setting/images.dart';

import '../../../setting/texts.dart';
import '../../onboarding/widget/input_widget.dart';

class SignUpView extends StatelessWidget {
  const SignUpView({super.key});

  @override
  Widget build(BuildContext context) {

    TextEditingController _emailController = TextEditingController();
    TextEditingController _passwordController = TextEditingController();

    return Scaffold(
      appBar: AppBar(),
      body: SafeArea(
        child: SizedBox(
          width: MediaQuery
              .of(context)
              .size
              .width,
          child: Column(
            children: [
              SizedBox(
                width: 150,
                height: 150,
                child: Image.asset(Images.logo(context)),
              ),
              SizedBox(height: 18),
              Text(
                Texts.toCapitalize(Texts.createAccout),
                style: GoogleFonts.nunito(
                  textStyle: TextStyle(
                    color: Theme
                        .of(context)
                        .colorScheme
                        .background,
                    fontSize: 24,
                    fontWeight: FontWeight.w700,
                  ),
                ),
              ),
              SizedBox(height: 20),
              Container(
                width: MediaQuery
                    .of(context)
                    .size
                    .width * 0.94,
                // color: Colors.red,
                child: Column(
                  children: [
                    InputWidget(
                      hint: Texts.email,
                      icon: Icons.email_outlined,
                      textInputType: TextInputType.text,
                      regExp: RegExp(""),
                      textEditingController: _emailController,

                    ),
                    SizedBox(height: 10,),
                    InputWidget(
                      hint: Texts.password,
                      icon: Iconsax.key,
                      textInputType: TextInputType.text,
                      regExp: RegExp(""),
                      textEditingController: _passwordController,
                      type: "password",
                    )
                  ],
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
