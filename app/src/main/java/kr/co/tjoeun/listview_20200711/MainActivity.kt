package kr.co.tjoeun.listview_20200711

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.tjoeun.listview_20200711.adapters.StudentAdapter
import kr.co.tjoeun.listview_20200711.datas.Student

class MainActivity : AppCompatActivity() {

//    학생 데이터를 담고 있는 목록
    val mStudentList = ArrayList<Student>()

//    목록에 담긴 데이터를 뿌려주는 어댑터
     lateinit var mAdapter : StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)
        studentListView.adapter = mAdapter
        mStudentList.add(Student("조경진", "서울시 은평구", 1994))
        mStudentList.add(Student("김문기", "경기도 남양주시", 1994))
        mStudentList.add(Student("오윤도", "경기도 남양주시", 1997))
        mStudentList.add(Student("이진슬", "서울시 강서구", 1997))
        mStudentList.add(Student("최지혁", "서울시 강동구", 1992))
        mStudentList.add(Student("최현일", "경기도 남양주시", 1990))
        mStudentList.add(Student("황선혜", "서울시 금천구", 1996))

        mAdapter.notifyDataSetChanged()

        studentListView.setOnItemClickListener { parent, view, position, id ->
//            position을 이용해서 클릭된 학생 받아오기
            val clickedStudent = mStudentList[position]

//            받아온 학생의 이름을 토스트로 띄우기
            Toast.makeText(this, clickedStudent.name, Toast.LENGTH_SHORT).show()
        }

        studentListView.setOnItemLongClickListener { parent, view, position, id ->

//            오래 눌린 사람을 목록에서 삭제.
            mStudentList.removeAt(position)


//            어댑터가 새로고침 하도록
            mAdapter.notifyDataSetChanged()


//            Boolean값을 리턴해줘야 한다.
            return@setOnItemLongClickListener true

        }
    }
}