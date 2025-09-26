import 'package:flutter/material.dart';
import 'package:shoes/setting/colors.dart';

ThemeData lightMode = ThemeData(
  colorScheme: ColorScheme.light(
    brightness: Brightness.light,
    primary: CustomColors.colorPrimaryWhite,
    background: CustomColors.textPrimaryWhite,
    onBackground: CustomColors.textPrimaryDark,
    outline: CustomColors.borderColorWhite,
  ),
);
ThemeData darkMode = ThemeData(
  colorScheme: ColorScheme.dark(
    brightness: Brightness.dark,
    primary: CustomColors.colorPrimaryDark,
    background: CustomColors.textPrimaryDark,
    onBackground: CustomColors.textPrimaryWhite,
    outline: CustomColors.borderColorDark,
  ),
);
