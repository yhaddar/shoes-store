import 'package:get/get.dart';

class AuthenticationController extends GetxController {
  Rx<bool> isShow = true.obs;

  void show() => isShow.value = !isShow.value;

}
