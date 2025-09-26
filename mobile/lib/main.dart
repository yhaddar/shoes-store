import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:shoes/setting/theme.dart';
import 'package:shoes/view/onboarding/screen/welcome_screen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      title: 'Flutter Demo',
      debugShowCheckedModeBanner: false,
      theme: lightMode,
      themeMode: ThemeMode.system,
      darkTheme: darkMode,
      home: const WelcomeScreen(),
    );
  }
}