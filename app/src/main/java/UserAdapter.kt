import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationn.R


class UserAdapter(private var userList:List<UserData>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

inner class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val image: ImageView =itemView.findViewById(R.id.imageView)
    val username:TextView=itemView.findViewById(R.id.userName)
}

 fun setFilteredList(userList: List<UserData>){
     this.userList = userList
     notifyDataSetChanged()
 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
       return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.image.setImageResource(userList[position].image)
        holder.username.text = userList[position].username

    }
}


