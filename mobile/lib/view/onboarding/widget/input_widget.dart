import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:iconsax/iconsax.dart';
import 'package:shoes/setting/colors.dart';
import 'package:shoes/view/authentication/controller/authentication_controller.dart';

import '../../../setting/texts.dart';

class InputWidget extends StatelessWidget {
  final String hint;
  final IconData icon;
  final TextEditingController textEditingController;
  final RegExp regExp;
  final TextInputType textInputType;
  final String? type;

  const InputWidget({
    required this.hint,
    required this.icon,
    required this.textInputType,
    required this.regExp,
    required this.textEditingController,
    this.type,
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    final AuthenticationController authenticationController = Get.put(
      AuthenticationController(),
    );
    return TextFormField(
      controller: textEditingController,
      keyboardType: textInputType,
      obscureText: type == "password"
          ? authenticationController.isShow.value
          : false,
      decoration: InputDecoration(
        border: OutlineInputBorder(
          borderSide: BorderSide(
            width: 2,
            color: Theme.of(context).colorScheme.outline.withOpacity(0.7),
          ),
          borderRadius: BorderRadius.circular(10),
        ),
        errorBorder: OutlineInputBorder(
          borderSide: BorderSide(width: 2, color: CustomColors.danger),
          borderRadius: BorderRadius.circular(10),
        ),
        prefixIcon: Icon(icon),
        hintText: Texts.toFirstLetterUpperCase(hint),
        hintStyle: GoogleFonts.nunito(
          color: Theme.of(context).colorScheme.background.withOpacity(0.7),
        ),
        suffixIcon: type == "password"
            ? Obx(() => InkWell(
          onTap: () => authenticationController.show(),
          child: Icon(
            authenticationController.isShow.value
                ? Iconsax.eye
                : Iconsax.eye_slash,
          ),
        ))
            : null,
      ),
      validator: (String? value) {
        if (value!.isEmpty) {
          return "the field is empty";
        } else if (!regExp.hasMatch(value)) {
          return "this field was invalid";
        }
        return null;
      },
    );

  }
}
