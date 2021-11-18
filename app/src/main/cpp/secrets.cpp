#include "secrets.hpp"

#include <jni.h>

#include "sha256.hpp"
#include "sha256.cpp"

/* Copyright (c) 2020-present Klaxit SAS
*
* Permission is hereby granted, free of charge, to any person
* obtaining a copy of this software and associated documentation
* files (the "Software"), to deal in the Software without
* restriction, including without limitation the rights to use,
* copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the
* Software is furnished to do so, subject to the following
* conditions:
*
* The above copyright notice and this permission notice shall be
* included in all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
* EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
* OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
* NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
* HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
* WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
* FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
* OTHER DEALINGS IN THE SOFTWARE.
*/

char *customDecode(char *str) {
    /* Add your own logic here
    * To improve your key security you can encode it before to integrate it in the app.
    * And then decode it with your own logic in this function.
    */
    return str;
}

jstring getOriginalKey(
        char *obfuscatedSecret,
        int obfuscatedSecretSize,
        jstring obfuscatingJStr,
        JNIEnv *pEnv) {

    // Get the obfuscating string SHA256 as the obfuscator
    const char *obfuscatingStr = pEnv->GetStringUTFChars(obfuscatingJStr, NULL);
    char buffer[2 * SHA256::DIGEST_SIZE + 1];

    sha256(obfuscatingStr, buffer);
    const char *obfuscator = buffer;

    // Apply a XOR between the obfuscated key and the obfuscating string to get original string
    char out[obfuscatedSecretSize + 1];
    for (int i = 0; i < obfuscatedSecretSize; i++) {
        out[i] = obfuscatedSecret[i] ^ obfuscator[i % strlen(obfuscator)];
    }

    // Add string terminal delimiter
    out[obfuscatedSecretSize] = 0x0;

    //(Optional) To improve key security
    return pEnv->NewStringUTF(customDecode(out));
}

extern "C"
JNIEXPORT jstring JNICALL
Java_MensajeOculto_Secrets_getputoElQueloLEA(
        JNIEnv *pEnv,
        jobject pThis,
        jstring packageName) {
    char obfuscatedSecret[] = { 0x1a, 0xd, 0x41, 0x13, 0x7a, 0x0, 0x1d, 0x30, 0x9, 0x7f, 0x57, 0x53, 0x43, 0x16, 0x52, 0x57, 0x12, 0x7 };
    return getOriginalKey(obfuscatedSecret, sizeof(obfuscatedSecret), packageName, pEnv);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_MensajeOculto_Secrets_getNoMEDIGAS(
        JNIEnv* pEnv,
        jobject pThis,
        jstring packageName) {
     char obfuscatedSecret[] = { 0x40, 0xe, 0x11, 0x47, 0x2f, 0x52, 0x1d, 0x67, 0x5c, 0x7b, 0x6, 0x5, 0x13, 0x45, 0x0, 0x2, 0x16, 0x0 };
     return getOriginalKey(obfuscatedSecret, sizeof(obfuscatedSecret), packageName, pEnv);
}
