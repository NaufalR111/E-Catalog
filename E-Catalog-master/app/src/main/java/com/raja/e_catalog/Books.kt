package com.raja.e_catalog

import java.io.Serializable

data class Books(
    val items: List<Item?>?,
    val kind: String?,
    val totalItems: Int?
) : Serializable {
    data class Item(
        val accessInfo: AccessInfo?,
        val etag: String?,
        val id: String?,
        val kind: String?,
        val saleInfo: SaleInfo?,
        val searchInfo: SearchInfo?,
        val selfLink: String?,
        val volumeInfo: VolumeInfo?
    ) : Serializable {
        data class AccessInfo(
            val accessViewStatus: String?,
            val country: String?,
            val embeddable: Boolean?,
            val epub: Epub?,
            val pdf: Pdf?,
            val publicDomain: Boolean?,
            val quoteSharingAllowed: Boolean?,
            val textToSpeechPermission: String?,
            val viewability: String?,
            val webReaderLink: String?
        ) : Serializable {
            data class Epub(
                val isAvailable: Boolean?
            ) : Serializable

            data class Pdf(
                val isAvailable: Boolean?
            ) : Serializable
        }

        data class SaleInfo(
            val country: String?,
            val isEbook: Boolean?,
            val saleability: String?
        ) : Serializable

        data class SearchInfo(
            val textSnippet: String?
        ) : Serializable

        data class VolumeInfo(
            val allowAnonLogging: Boolean?,
            val authors: List<String?>?,
            val canonicalVolumeLink: String?,
            val contentVersion: String?,
            val imageLinks: ImageLinks?,
            val industryIdentifiers: List<IndustryIdentifier?>?,
            val infoLink: String?,
            val language: String?,
            val maturityRating: String?,
            val panelizationSummary: PanelizationSummary?,
            val previewLink: String?,
            val printType: String?,
            val publisher: String?,
            val readingModes: ReadingModes?,
            val title: String?,
            val description: String?
        ) : Serializable {
            data class ImageLinks(
                val smallThumbnail: String?,
                val thumbnail: String?
            ) : Serializable

            data class IndustryIdentifier(
                val identifier: String?,
                val type: String?
            ) : Serializable

            data class PanelizationSummary(
                val containsEpubBubbles: Boolean?,
                val containsImageBubbles: Boolean?
            ) : Serializable

            data class ReadingModes(
                val image: Boolean?,
                val text: Boolean?
            ) : Serializable
        }
    }
}