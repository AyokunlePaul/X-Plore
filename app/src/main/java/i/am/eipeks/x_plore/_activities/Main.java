package i.am.eipeks.x_plore._activities;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import i.am.eipeks.x_plore.R;


public class Main extends AppCompatActivity implements View.OnClickListener {

//    private ImageView call;
//    private LinearLayout.LayoutParams layoutParams;
    private FloatingActionButton addNewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNewTask = (FloatingActionButton) findViewById(R.id.add_new_task);
        addNewTask.setOnClickListener(this);
//        call = (ImageView) findViewById(R.id.call);
//        call.setTag("Call Logo");
//
//        call.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());
//                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
//
//                ClipData clipData = new ClipData(view.getTag().toString(), mimeTypes, item);
//
//                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(call);
//
//                view.startDrag(clipData, shadowBuilder, null, 0);
//
//                return true;
//            }
//        });
//
//        call.setOnDragListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_new_task:
                break;
        }
    }

//    @Override
//    public boolean onDrag(View view, DragEvent dragEvent) {
//        switch (view.getId()){
//            case R.id.call:
//                switch (dragEvent.getAction()){
//                    case DragEvent.ACTION_DRAG_STARTED:
//                        layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
//                        break;
//                    case DragEvent.ACTION_DRAG_ENTERED:
//                        int x_cord = (int) dragEvent.getX();
//                        int y_cord = (int) dragEvent.getY();
//                        break;
//                    case DragEvent.ACTION_DRAG_EXITED:
//                        x_cord = (int) dragEvent.getX();
//                        y_cord = (int) dragEvent.getY();
//                        layoutParams.leftMargin = x_cord;
//                        layoutParams.topMargin = y_cord;
//                        view.setLayoutParams(layoutParams);
//                        break;
//                    case DragEvent.ACTION_DRAG_LOCATION:
//                        x_cord = (int) dragEvent.getX();
//                        y_cord = (int) dragEvent.getY();
//                }
//                return true;
//            default:
//                break;
//        }
//        return false;
//    }
}
