package com.example.testapifromwordpress.pojo

data class Products(
    val products: List<Product>?=null
) {
    data class Product(
        val attributes: List<Attribute>?=null,
        val average_rating: String?=null,
        val backordered: Boolean?=null,
        val backorders_allowed: Boolean?=null,
        val button_text: String?=null,
        val catalog_visibility: String?=null,
        val categories: List<String>?=null,
        val created_at: String?=null,
        val cross_sell_ids: List<Int>?=null,
        val description: String?=null,
        val dimensions: Dimensions?=null,
        val download_expiry: Int?=null,
        val download_limit: Int?=null,
        val download_type: String?=null,
        val downloadable: Boolean?=null,
        val downloads: List<Any>?=null,
        val featured: Boolean?=null,
        val featured_src: String?=null,
        val grouped_products: List<Any>?=null,
        val id: Int?=null,
        val images: List<Image>?=null,
        val in_stock: Boolean?=null,
        val managing_stock: Boolean?=null,
        val menu_order: Int?=null,
        val on_sale: Boolean?=null,
        val parent: List<Any>?=null,
        val parent_id: Int?=null,
        val permalink: String?=null,
        val price: String?=null,
        val price_html: String?=null,
        val product_url: String?=null,
        val purchase_note: String?=null,
        val purchaseable: Boolean?=null,
        val rating_count: Int?=null,
        val regular_price: String?=null,
        val related_ids: List<Int>?=null,
        val reviews_allowed: Boolean?=null,
        val sale_price: Any?=null,
        val shipping_class: String?=null,
        val shipping_class_id: Any?=null,
        val shipping_required: Boolean?=null,
        val shipping_taxable: Boolean?=null,
        val short_description: String?=null,
        val sku: String?=null,
        val sold_individually: Boolean?=null,
        val status: String?=null,
        val stock_quantity: Any?=null,
        val tags: List<Any>?=null,
        val tax_class: String?=null,
        val tax_status: String?=null,
        val taxable: Boolean?=null,
        val title: String?=null,
        val total_sales: Int?=null,
        val type: String?=null,
        val updated_at: String?=null,
        val upsell_ids: List<Int>?=null,
        val variations: List<Variation>?=null,
        val virtual: Boolean?=null,
        val visible: Boolean?=null,
        val weight: Any?=null
    ) {
        data class Attribute(
            val name: String?=null,
            val options: List<String>?=null,
            val position: Int?=null,
            val slug: String?=null,
            val variation: Boolean?=null,
            val visible: Boolean?=null
        )

        data class Dimensions(
            val height: String?=null,
            val length: String?=null,
            val unit: String?=null,
            val width: String?=null
        )

        data class Image(
            val alt: String?=null,
            val created_at: String?=null,
            val id: Int?=null,
            val position: Int?=null,
            val src: String?=null,
            val title: String?=null,
            val updated_at: String?=null
        )

        data class Variation(
            val attributes: List<Attribute>?=null,
            val backordered: Boolean?=null,
            val backorders_allowed: Boolean?=null,
            val created_at: String?=null,
            val dimensions: Dimensions?=null,
            val download_expiry: Int?=null,
            val download_limit: Int?=null,
            val downloadable: Boolean?=null,
            val downloads: List<Any>?=null,
            val id: Int?=null,
            val image: List<Image>?=null,
            val in_stock: Boolean?=null,
            val managing_stock: Boolean?=null,
            val on_sale: Boolean?=null,
            val permalink: String?=null,
            val price: String?=null,
            val purchaseable: Boolean?=null,
            val regular_price: String?=null,
            val sale_price: String?=null,
            val shipping_class: String?=null,
            val shipping_class_id: Any?=null,
            val sku: String?=null,
            val stock_quantity: Int?=null,
            val tax_class: String?=null,
            val tax_status: String?=null,
            val taxable: Boolean?=null,
            val updated_at: String?=null,
            val virtual: Boolean?=null,
            val visible: Boolean?=null,
            val weight: Any?=null
        ) {
            data class Attribute(
                val name: String?=null,
                val option: String?=null,
                val slug: String?=null
            )

            data class Dimensions(
                val height: String?=null,
                val length: String?=null,
                val unit: String?=null,
                val width: String?=null
            )

            data class Image(
                val alt: String?=null,
                val created_at: String?=null,
                val id: Int?=null,
                val position: Int?=null,
                val src: String?=null,
                val title: String?=null,
                val updated_at: String?=null
            )
        }
    }
}