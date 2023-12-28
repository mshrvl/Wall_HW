interface Attachment {
    val type: String
}

data class Photo(val id: Int, val ownerId: Int, val description: String)

data class Audio(val id: Int, val ownerId: Int, val duration: Int)

data class Video(val id: Int, val ownerId: Int, val duration: Int, val addingDate: Int)

data class File(val id: Int,  val ownerId: Int, val ext: String, val width: Int)

data class Sticker (val productId: Int, val animationUrl: String)

data class photoAttachment(override val type: String, val photo: Photo) : Attachment

data class audioAttachment(override val type: String, val audio: Audio) : Attachment

data class videoAttachment(override val type: String, val video: Video) : Attachment

data class fileAttachment(override val type: String, val file: File): Attachment

data class stickerAttachment(override val type: String, val sticker: Sticker): Attachment




data class Post(
    val id: Int,
    val reposts: Int,
    val ownerId: Int,
    val date: Int,
    val text: String?,
    val friendOnly: Boolean,
    val signerId: Int?,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isFavourite: Boolean,
    val likesInfo: Likes.LikesInfo = Likes.LikesInfo(0, false, false, false)
)

object Likes {
    data class LikesInfo(
        val count: Int,
        val userLikes: Boolean,
        val canLike: Boolean,
        val canPublish: Boolean
    )
}

object WallService {
    private var posts = emptyArray<Post>()
    private var id = 0

    fun clear() {
        posts = emptyArray()
        id = 0
    }

    fun add(post: Post): Post {
        val newPost = post.copy(id = generateId())
        posts += newPost
        return newPost
    }

    private fun generateId(): Int {
        id++
        return id
    }

    fun update(post: Post): Boolean {
        for ((index, existingPost) in posts.withIndex()) {
            if (existingPost.id == post.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }
}

fun main() {
    val post = Post(0, 0, 2, 12, "T1", true, 4, true, true, true, false)
    val newPost = WallService.add(post.copy())
    println("Post added with ID: ${newPost.id}")

    val updatedPost = newPost.copy(text = null, signerId = null)
    if (WallService.update(updatedPost)) {
        println("Post updated successfully")
    } else {
        println("Post not found")
    }
}
