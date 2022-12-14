package kr.hs.entrydsm.exit.domain.image.usecase

import kr.hs.entrydsm.exit.domain.image.exception.InvalidImageException
import kr.hs.entrydsm.exit.domain.image.presentation.dto.response.ImageUrlResponse
import kr.hs.entrydsm.exit.global.aws.s3.AwsS3Facade
import kr.hs.entrydsm.exit.global.aws.s3.ImageType
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

@Service
class UploadImageUseCase(
    private val awsS3Facade: AwsS3Facade
) {

    fun execute(file: MultipartFile, imageType: ImageType): ImageUrlResponse {

        val filePath = awsS3Facade.saveImage(multipartToFile(file), imageType)

        return ImageUrlResponse(filePath)
    }

    private fun multipartToFile(multipartFile: MultipartFile?): File {

        if (multipartFile == null || multipartFile.isEmpty || multipartFile.originalFilename == null) {
            throw InvalidImageException
        }
        val file = File(multipartFile.originalFilename!!)

        try {
            FileOutputStream(file).use { outputStream -> outputStream.write(multipartFile.bytes) }
        } catch (e: IOException) {
            throw InvalidImageException
        }
        return file
    }

}