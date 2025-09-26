import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:shoes/setting/colors.dart';
import 'package:shoes/setting/images.dart';
import 'package:shoes/view/authentication/controller/authentication_controller.dart';
import 'package:shoes/view/authentication/ui/sign_up_view.dart';
import 'package:shoes/view/authentication/widget/bottom_widget.dart';

import '../../../setting/buttons.dart';
import '../../../setting/texts.dart';
import '../widget/oauth2_1_widget.dart';

class SignInView extends StatelessWidget {
  const SignInView({super.key});

  @override
  Widget build(BuildContext context) {
    final List<Map<String, String>> socials = [
      {"image": Images.facebook, "title": Texts.facebookText},
      {"image": Images.google, "title": Texts.googleText},
      {"image": Images.apple(context), "title": Texts.appleText},
    ];

    return Scaffold(
      appBar: AppBar(),
      body: SafeArea(
        child: SizedBox(
          width: MediaQuery.of(context).size.width,
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              SizedBox(
                width: 350,
                height: 350,
                child: Image.asset(Images.loginImage),
              ),

              SizedBox(
                width: MediaQuery.of(context).size.width * 0.8,
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: List.generate(
                    socials.length,
                    (index) => Oauth21Widget(
                      title: socials[index]["title"]!,
                      image: socials[index]["image"]!,
                    ),
                  ),
                ),
              ),
              SizedBox(height: 15),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Container(
                    width: MediaQuery.of(context).size.width * 0.4,
                    color: Theme.of(context).colorScheme.outline,
                    height: 2,
                  ),
                  SizedBox(width: 5),
                  Text(
                    "or",
                    style: GoogleFonts.nunito(
                      color: Theme.of(context).colorScheme.background,
                      fontSize: 16,
                    ),
                  ),
                  SizedBox(width: 5),
                  Container(
                    width: MediaQuery.of(context).size.width * 0.4,
                    color: Theme.of(context).colorScheme.outline,
                    height: 2,
                  ),
                ],
              ),
              SizedBox(height: 15),
              Buttons.elevatedButton(
                "sign in with password",
                context,
                () {},
                theme: true,
              ),
              SizedBox(height: 20),
              BottomWidget(
                title: Texts.dontHaveAccount,
                text: Texts.signUp,
                redirect: () => Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => SignUpView()),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
