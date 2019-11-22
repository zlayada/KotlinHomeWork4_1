package com.netology.kotlinhomework4_1


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var post = Post(
        1,
        "Джонатон Уэйн",
        "Самое первое сообщение в этой социальной сети. Где отображаются переносы слов, но не более ограниченных строк.",
        "18 ноября 2019",
        false,
        false,
        false,
        0,
        0,
        0
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView_data.text = post.created
        textView_text_note.text = post.content
        textView_author.text = post.author

        textView_counte_share.text = zeroСheck(post.shareCounter)
        textView_counte_commit.text = zeroСheck(post.commentCounter)
        textView_counte_like.text = zeroСheck(post.likedCounter)

    }

    // Провеока на "0" счетчиков для визуализации в TextView
    fun zeroСheck(counter: Int): String {

        val counterText: String

            if (counter==0) {
                counterText = ""
            } else {
                counterText = counter.toString()
            }

        return counterText
    }

    fun onClick(view: View){

        /*val massage = Toast.makeText (this, "Click", Toast.LENGTH_SHORT)
        massage.show()*/

        when (view) {
            imageBtn_like -> {
                if (post.likedByMe == false) {
                    imageBtn_like.setImageResource(R.drawable.ic_favorite_red_24dp)
                    textView_counte_like.setTextColor(Color.RED)
                    post.likedCounter +=1
                    post.likedByMe = true
                    textView_counte_like.text = post.likedCounter.toString()

                } else {
                    imageBtn_like.setImageResource(R.drawable.ic_favorite_black_24dp)
                    textView_counte_like.setTextColor(Color.GRAY)
                    post.likedCounter -=1
                    post.likedByMe = false
                    textView_counte_like.text = zeroСheck(post.likedCounter)
                }
            }

            imageBtn_commit -> {
                if (post.CommentdByMe == false) {
                    imageBtn_commit.setImageResource(R.drawable.ic_mode_comment_red_24dp)
                    textView_counte_commit.setTextColor(Color.RED)
                    post.commentCounter +=1
                    post.CommentdByMe = true
                    textView_counte_commit.text = post.commentCounter.toString()
                } else {
                    imageBtn_commit.setImageResource(R.drawable.ic_mode_comment_black_24dp)
                    textView_counte_commit.setTextColor(Color.GRAY)
                    post.commentCounter -=1
                    post.CommentdByMe = false
                    textView_counte_commit.text = zeroСheck(post.commentCounter)
                }
            }

            imageBtn_share -> {
                if (post.ShareByMe == false) {
                    imageBtn_share.setImageResource(R.drawable.ic_share_red_24dp)
                    textView_counte_share.setTextColor(Color.RED)
                    post.shareCounter +=1
                    post.ShareByMe = true
                    textView_counte_share.text = post.shareCounter.toString()
                } else {
                    imageBtn_share.setImageResource(R.drawable.ic_share_black_24dp)
                    textView_counte_share.setTextColor(Color.GRAY)
                    post.shareCounter -=1
                    post.ShareByMe = false
                    textView_counte_share.text = zeroСheck(post.shareCounter)
                }
            }
        }
    }
}
