package com.amiprobashi.root.qrcodekt

import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class QRGSaverKt {
    @JvmOverloads
    fun save(
        saveLocation: String,
        imageName: String,
        bitmap: Bitmap,
        imageFormat: Int = QRGContentsKt.ImageType.IMAGE_PNG
    ): Boolean {
        var success = false
        val imageDetail = saveLocation + imageName + imgFormat(imageFormat)
        val outStream: FileOutputStream
        val file = File(saveLocation)
        if (!file.exists()) {
            file.mkdir()
        } else {
            Log.d("QRGSaver", "Folder Exists")
        }
        try {
            outStream = FileOutputStream(imageDetail)
            bitmap.compress(compressFormat(imageFormat), 100, outStream)
            outStream.flush()
            outStream.close()
            success = true
        } catch (e: IOException) {
            Log.d("QRGSaver", e.toString())
        }
        return success
    }

    private fun imgFormat(imageFormat: Int): String {
        return if (imageFormat == QRGContentsKt.ImageType.IMAGE_PNG) ".png" else ".jpg"
    }

    private fun compressFormat(imageFormat: Int): CompressFormat {
        return if (imageFormat == QRGContentsKt.ImageType.IMAGE_PNG) CompressFormat.PNG else if (imageFormat == QRGContentsKt.ImageType.IMAGE_WEBP) CompressFormat.WEBP else CompressFormat.JPEG
    }
}
