data class Post(
    val id: Int,
    val reposts: Int,
    val ownerId: Int,
    val date: Int,
    val text: String,
    val friendOnly: Boolean,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isFavourite: Boolean
)

object Likes {
    data class LikesInfo(
        val count: Int,
        val userLikes: Boolean,
        val canLike: Boolean,
        val canPublish: Boolean,
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
    val likesInfo = Likes.LikesInfo(10, true, true, true)
    val newPost = WallService.add(post.copy())
    println("Post added with ID: ${newPost.id}")

    val updatedPost = newPost.copy(text = "Updated Text")
    if (WallService.update(updatedPost)) {
        println("Post updated successfully")
    } else {
        println("Post not found")
    }
}
