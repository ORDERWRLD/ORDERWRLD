package com.vip.inj64;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.IBinder;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.widget.RelativeLayout.ALIGN_PARENT_LEFT;
import static android.widget.RelativeLayout.ALIGN_PARENT_RIGHT;
import android.graphics.PixelFormat;
import android.graphics.Canvas;
import android.view.ViewConfiguration;
import java.io.DataOutputStream;
import android.content.SharedPreferences;
import android.net.wifi.hotspot2.pps.HomeSp;
import java.io.FileOutputStream;
import java.io.OutputStream;
import android.os.Environment;
import java.io.FileNotFoundException;
public class overLayService extends Service {
    static{
        System.loadLibrary("native-lib");
    }
    //////////////////////// target //////////////////////////
	public static String socket;
	public String daemonPath;
    String LibName = "libLibServer.so";
    String targetPackage = "com.pubg.imobile";
	public native void SettingValue(int setting_code,boolean value);

    ESPView overlayView;
    WindowManager windowManager;
	Process process;   // native void my();
	//private native String web();
//  private native String tg();
//  private native String tg3();
	//private native String tg2();
	//////////////////////// Strings//////////////////////////
    private String mText = "sss_aus";
    private String mEdi = "Flame Edition";
    private String mCredit = "Powered By TeamEX";
    private String tagbgmi = "Inject BGMI";
    public static boolean isVisual=false;
    public static boolean isAim=false;
    //////////////////////// esp //////////)/)))))))///
	public native void SettingMemory(int setting_code, boolean value);
	
    	//Process process;
    
//  public static native String jTxt();
    //////////////////////// size ////////////////////////////

    int MENU_WIDTH = 300;
    int MENU_HEIGHT = 350;
    float MENU_CORNER = 4f;
    int ICON_SIZE = 60; //Change both width and height of image
    float ICON_ALPHA = 0.7f; //Transparent
    /////////////////////////// color ////////////////////////////
    int MENU_BG_COLOR = Color.argb(165,255,255,255); //#AARRGGBB
    int MENU_BG_COL2 = Color.argb(175,255,255,255);
    int Accent_ON = Color.parseColor("#316ffe");
    int Acent_OFF = Color.parseColor("#9c9c9c");
    /////////////////////// layout ///////////////////////////
    RelativeLayout mCollapsed, mRootContainer;
    LinearLayout mExpanded, patches, mSettings, mCollapse;
    LinearLayout.LayoutParams scrlLLExpanded, scrlLL;
    ImageView startimage;
    FrameLayout rootFrame;
    ScrollView scrollView;
    LinearLayout startL, settingL, fBg,vBg,aBg,espL;
	LinearLayout cheatL,eslL;
    ImageView startI, settingI,espI;
    Button gameB,btn;
    LinearLayout bgmiC,settingC,espC;
    private Switch sT;
    /////////////////////////// window manager ///////////////
    
    WindowManager mWindowManager;
    WindowManager.LayoutParams params;

    public void onCreate() {
        super.onCreate();
		loadAssets();
        initFloat();
           }

    private int getLayoutType() {
        int LAYOUT_FLAG;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_PHONE;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_TOAST;
        } else {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        }
        return LAYOUT_FLAG;
    }

    private void initFloat() {
        rootFrame = new FrameLayout(this); // Global markup
        rootFrame.setOnTouchListener(onTouchListener());
        mRootContainer = new RelativeLayout(this); // Markup on which two markups of the icon and the menu itself will be placed
        mCollapsed = new RelativeLayout(this); // Markup of the icon (when the menu is minimized)
        mCollapsed.setVisibility(View.VISIBLE);
        mCollapsed.setAlpha(ICON_ALPHA);

        //********** The box of the mod menu **********
     GradientDrawable gds = new GradientDrawable();
	 gds.setColor(MENU_BG_COLOR);
	 gds.setCornerRadius(dp(5));
		mExpanded = new LinearLayout(this); // Menu markup (when the menu is expanded)
        mExpanded.setVisibility(View.GONE);
        //mExpanded.setBackground(gds);
        mExpanded.setOrientation(LinearLayout.VERTICAL);
        mExpanded.setPadding(8, 8, 8, 8); //So borders would be visible
        mExpanded.setLayoutParams(new LinearLayout.LayoutParams(dp(MENU_WIDTH), -1));
		int[] colorsCRNWC = { Color.parseColor("#212121"), Color.parseColor("#212121") }; android.graphics.drawable.GradientDrawable CRNWC = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, colorsCRNWC);
		CRNWC.setCornerRadii(new float[]{(int)0,(int)0,(int)84,(int)84,(int)0,(int)0,(int)84,(int)84});
		CRNWC.setStroke((int) 7, Color.parseColor("#FF9100"));
		mExpanded.setElevation((float) 5);
		mExpanded.setBackground(CRNWC);

LinearLayout fm = new LinearLayout(this);
        fm.setLayoutParams(new LinearLayout.LayoutParams(-1, dp(60)));
        fm.setGravity(Gravity.CENTER);
        fm.setOrientation(LinearLayout.VERTICAL);
        fm.setPadding(8, 8, 8, 8);
		fm.setBackgroundColor(Color.TRANSPARENT);
        fm.setElevation((float) 5);
     //   fm.setBackground(CRNKY);
        TextView hj4rgh = new TextView(this);
        hj4rgh.setText((new Object() {
						   int t;
						   public String toString() {
							   byte[] buf = new byte[12];
							   t = -344349252;
							   buf[0] = (byte) (t >>> 7);
							   t = -606951175;
							   buf[1] = (byte) (t >>> 11);
							   t = 1519671494;
							   buf[2] = (byte) (t >>> 19);
							   t = 498760865;
							   buf[3] = (byte) (t >>> 11);
							   t = 547336844;
							   buf[4] = (byte) (t >>> 24);
							   t = -704038454;
							   buf[5] = (byte) (t >>> 22);
							   t = 675340054;
							   buf[6] = (byte) (t >>> 17);
							   t = 994091162;
							   buf[7] = (byte) (t >>> 9);
							   t = 1083654513;
							   buf[8] = (byte) (t >>> 8);
							   t = -56996106;
							   buf[9] = (byte) (t >>> 8);
							   t = -356183501;
							   buf[10] = (byte) (t >>> 10);
							   t = 706789925;
							   buf[11] = (byte) (t >>> 15);
							   return new String(buf);
						   }
					   }.toString()));
        hj4rgh.setTextColor(Color.parseColor("#FF9100"));
        hj4rgh.setLayoutParams(new LinearLayout.LayoutParams(-2,-2));
        hj4rgh.setTextSize(16);
        hj4rgh.setGravity(Gravity.CENTER);
        hj4rgh.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/nv.ttf"));

                mExpanded.addView(fm);
        fm.addView(hj4rgh);
		LinearLayout bg = new LinearLayout(this);
        bg.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        bg.setGravity(Gravity.CENTER_VERTICAL);
		
		ScrollView sc = new ScrollView(this);
		sc.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
		sc.setVerticalScrollBarEnabled(false);
		
		bg.addView(sc);
		LinearLayout bypass = new LinearLayout(this);
        bypass.setLayoutParams(new LinearLayout.LayoutParams(-1, dp(100)));
        bypass.setGravity(Gravity.CENTER_VERTICAL);
        bypass.setOrientation(LinearLayout.VERTICAL);
        bypass.setPadding(dp(8), dp(8),dp(8), dp(8));
		int[] colorsCRNXE = { Color.parseColor("#393939"), Color.parseColor("#393939") }; android.graphics.drawable.GradientDrawable CRNXE = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, colorsCRNXE);
		CRNXE.setCornerRadii(new float[]{(int)89,(int)89,(int)0,(int)0,(int)89,(int)89,(int)0,(int)0});
		CRNXE.setStroke((int) 0, Color.parseColor("#000000"));
		bypass.setElevation((float) 5);
		bypass.setOrientation(LinearLayout.VERTICAL);
		bypass.setBackground(CRNXE);
		
		LinearLayout extr = new LinearLayout(this);
        extr.setLayoutParams(new LinearLayout.LayoutParams(-1, dp(200)));
        extr.setGravity(Gravity.CENTER_VERTICAL);
        extr.setOrientation(LinearLayout.VERTICAL);
        extr.setPadding(dp(8), dp(8),dp(8), dp(8));
		
		
mExpanded.addView(bg);
	sc.addView(bypass);
	//sc.addView(extr);
		HeaderC(bypass,"Antiban","#ff9100");
		fToggle(bypass,"Logo Bypss️", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if(!LoginActivity.jdidnd){
                            if(home.ducude){
                            //    cpp(web());
								//cpp(tg());
                            }
                        }
                    }
                }
            });
		fToggle(bypass,"Lobby Bypass ", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if(!LoginActivity.jdidnd){
                            if(home.ducude){
                          //      cpp(tg());
								//cpp(tg3());
								//cpp(tg());
                            }
                        }
                    }
                }
            });
		
	
			
		HeaderC(bypass,"Games Cheats","#ff9100");
		fToggle(bypass, "Magic Bullet", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if(!LoginActivity.jdidnd){
                            if(home.ducude){
                        //        cpp(tg2());
                            }
                        }
                    }
                }
            });
		fToggle(bypass, "Less Recoil", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if(!LoginActivity.jdidnd){
                            if(home.ducude){
                                SettingValue(35,isChecked);  
                            }
                        }
                    }
                }
            });
        fToggle(bypass, " Instant Hit ", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if(!LoginActivity.jdidnd){
                            if(home.ducude){
                                SettingValue(36,isChecked);  
                            }
                        }
                    }
                }
            });

		fToggle(bypass, " Small Crosshair", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if(!LoginActivity.jdidnd){
                            if(home.ducude){
                                SettingValue(38,isChecked);  
                            }
                        }
                    }
                }
            });


		fToggle(bypass, "X Hit ", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if(!LoginActivity.jdidnd){
                            if(home.ducude){
                                SettingValue(40,isChecked);  
                            }
                        }
                    }
                }
            });
        
		HeaderC(bypass,"Esp Menu","#ffffff");
		fToggle(bypass, "Esp On", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
						DrawESP();     
					} else{
						StopESP();		
					}

                }
            });
        fToggle(bypass, "Esp Player Box", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if(!LoginActivity.jdidnd){
                            if(home.ducude){
                                SettingValue(1,isChecked);  
                            }
                        }
                    }
                }
            });
        fToggle(bypass, "Esp Line", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if(!LoginActivity.jdidnd){
                            if(home.ducude){
                                SettingValue(2,isChecked);  
                            }
                        }
                    }
                }
            });
        fToggle(bypass, "Esp Player Distance", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if(!LoginActivity.jdidnd){
                            if(home.ducude){
                                SettingValue(3,isChecked);  
                            }
                        }
                    }
                }
            });

        fToggle(bypass, "Esp Player Health", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if(!LoginActivity.jdidnd){
                            if(home.ducude){
                                SettingValue(4,isChecked);  
                            }
                        }
                    }
                }
            });
        fToggle(bypass, "Esp Player Name", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if(!LoginActivity.jdidnd){
                            if(home.ducude){
                                SettingValue(5,isChecked);  
                            }
                        }
                    }
                }
            });
        fToggle(bypass, "Esp Player Head", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if(!LoginActivity.jdidnd){
                            if(home.ducude){
                                SettingValue(6,isChecked);  
                            }
                        }
                    }
                }
            });
        fToggle(bypass, "Esp Player Skeleton", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if(!LoginActivity.jdidnd){
                            if(home.ducude){
                                SettingValue(8,isChecked);  
                            }
                        }
                    }
                }
            });

        fToggle(bypass, "Esp Player Warning", new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if(!LoginActivity.jdidnd){
                            if(home.ducude){
                                SettingValue(7,isChecked);  
                                SettingValue(9,isChecked);  
                                SettingValue(10,isChecked);  
                            }
                        }
                    }
                }
            });
        
			
        /////////////////////////// onclicks////////////////////////
        
    //********** The icon to open mod menu **********
    startimage =new

    ImageView(this);
    startimage.setLayoutParams(new RelativeLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT));
    int applyDimension = (int) TypedValue.applyDimension(1, ICON_SIZE, getResources().getDisplayMetrics()); //Icon size
    startimage.getLayoutParams().height =applyDimension;
    startimage.getLayoutParams().width =applyDimension;
    //startimage.requestLayout();
    startimage.setScaleType(ImageView.ScaleType.FIT_XY);

    setImageFromAssets(startimage,"logo.png");
    //Initialize event handlers for buttons, etc.
    startimage.setOnTouchListener(

    onTouchListener());
    startimage.setOnClickListener(new View.OnClickListener()

    {
        public void onClick (View view){
        mCollapsed.setVisibility(View.GONE);
        mExpanded.setVisibility(View.VISIBLE);
    }
    });
    hj4rgh.setOnClickListener(new View.OnClickListener()

    {
        public void onClick (View view){
        mCollapsed.setVisibility(View.VISIBLE);
        mExpanded.setVisibility(View.GONE);
    }
    });

    //********** Params **********
    //Variable to check later if the phone supports Draw over other apps permission
    int iparams = Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O ? 2038 : 2002;
    params =new WindowManager.LayoutParams(WRAP_CONTENT,WRAP_CONTENT,iparams,8,-3);
    params.gravity =51;
    params.x =0;
    params.y =100;
    rootFrame.addView(mRootContainer);
    mRootContainer.addView(mCollapsed);
    mRootContainer.addView(mExpanded);
    mWindowManager =(WindowManager)

    getSystemService(WINDOW_SERVICE);
    mWindowManager.addView(rootFrame,params);
    mCollapsed.addView(startimage);

}


    private View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {
            final View collapsedView = mCollapsed;
            final View expandedView = mExpanded;
            private float initialTouchX, initialTouchY;
            private int initialX, initialY;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = motionEvent.getRawX();
                        initialTouchY = motionEvent.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        int rawX = (int) (motionEvent.getRawX() - initialTouchX);
                        int rawY = (int) (motionEvent.getRawY() - initialTouchY);
                        mExpanded.setAlpha(1f);
                        mCollapsed.setAlpha(1f);
                        //The check for Xdiff <10 && YDiff< 10 because sometime elements moves a little while clicking.
                        //So that is click event.
                        if (rawX < 10 && rawY < 10 && isViewCollapsed()) {
                            //When user clicks on the image view of the collapsed layout,
                            //visibility of the collapsed layout will be changed to "View.GONE"
                            //and expanded view will become visible.
                            try {
                                collapsedView.setVisibility(View.GONE);
                                expandedView.setVisibility(View.VISIBLE);
                            } catch (NullPointerException e) {

                            }
                        }
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        mExpanded.setAlpha(0.5f);
                        mCollapsed.setAlpha(0.5f);
                        //Calculate the X and Y coordinates of the view.
                        params.x = initialX + ((int) (motionEvent.getRawX() - initialTouchX));
                        params.y = initialY + ((int) (motionEvent.getRawY() - initialTouchY));
                        //Update the layout with new X & Y coordinate
                        mWindowManager.updateViewLayout(rootFrame, params);
                        return true;
                    default:
                        return false;
                }
            }
        };
    }



    //Override our Srt Command so the Service doesnt try to recreate itself when the App is closed
    public int onStartCommand(Intent intent, int i, int i2) {
        return Service.START_NOT_STICKY;
    }
    private boolean isViewCollapsed() {
        return rootFrame == null || mCollapsed.getVisibility() == View.VISIBLE;
    }
    public IBinder onBind(Intent intent){
    return null;
}
    private void setImageFromAssets(ImageView image,String name){
        AssetManager assetManager=getBaseContext().getAssets();
        try{
            InputStream inputStream=assetManager.open(name);
            image.setImageDrawable(Drawable.createFromStream(inputStream,null));
        } catch (IOException e){
            Toast.makeText(this,"Error could not load image from assets folder \n"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }



    private int dp(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }
///////////////////////////////// Voids /////////////////////////////

    void HeaderC(Object obj, String text, String color) {
        TextView txt = new TextView(this);
        txt.setText(text);
        txt.setTextColor(Color.parseColor(color));
        txt.setTextSize(12);
        txt.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/dsp.ttf"));
        txt.setGravity(Gravity.CENTER_HORIZONTAL);
        if (obj instanceof ViewGroup) {
            ((ViewGroup) obj).addView((View) txt);
        }
    }
    void cpr(Object obj, String text, String color) {
        TextView txt = new TextView(this);
        txt.setText(text);
        txt.setTextColor(Color.parseColor(color));
        txt.setTextSize(12);
        txt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/tx.ttf"));
        txt.setGravity(Gravity.LEFT);
        if (obj instanceof ViewGroup) {
            ((ViewGroup) obj).addView((View)txt);
        }
    }
    private void fToggle(Object obj,String name, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
		sT = new Switch(this);
        sT.setText(name);
        sT.setTextColor(Color.WHITE);
        sT.setTextSize(13);
        sT.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/tx.ttf"));
        sT.setPadding(dp(0), dp(0), dp(0), dp(0));
        sT.setOnCheckedChangeListener(onCheckedChangeListener);
        sT.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        ColorStateList buttonStates = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_enabled},
                        new int[]{android.R.attr.state_checked},
                        new int[]{}
                },
                new int[]{
                        Color.GREEN,
                        Color.parseColor("#FF9100"),
                        Color.parseColor("#9c9c9c")
                }
        );
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sT.getThumbDrawable().setTintList(buttonStates);
            sT.getTrackDrawable().setTintList(buttonStates);
        }

        if (obj instanceof ViewGroup) {
            ((ViewGroup)obj).addView((View)sT);
            return;
        }
    }
    private void fButton(Object obj,String txt, String txtCol, CompoundButton.OnClickListener onClickListener){
      LinearLayout.LayoutParams btnL = new LinearLayout.LayoutParams(-1,dp(40));
      btnL.setMargins(dp(20),dp(5),dp(20),dp(5));
      GradientDrawable btnG = new GradientDrawable();
      btnG.setCornerRadius(dp(5));
      btnG.setColor(MENU_BG_COL2);
       btn = new Button(this);
       btn.setText(txt);
       btn.setTextColor(Color.parseColor(txtCol));
       btn.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/tx.ttf"));
       btn.setTextSize(12);
       btn.setLayoutParams(btnL);
       btn.setBackground(btnG);
       btn.setElevation(dp(5));
       btn.setOnClickListener(onClickListener);
        if(obj instanceof  ViewGroup){
            ((ViewGroup)obj).addView((View)btn);
        }
    }
    public void cpp(String path)
    {
        try
        {
            ExecuteElf("chmod 777 " + getFilesDir() + path);
            ExecuteElf(getFilesDir() + path);
            ExecuteElf("su -c chmod 777 " + getFilesDir() + path);
            ExecuteElf("su -c " + getFilesDir() + path);
        }
        catch (Exception e)
        {
        }
    }

    private void ExecuteElf(String shell)
    {
        String s=shell;
        try
        {
            Runtime.getRuntime().exec(s, null, null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
        public void onDestroy() {
        super.onDestroy();
       

        
        process.destroy();
    }
	
	
	private void DrawESP() {
        if (home.isRoot) {
            socket = "su -c " + daemonPath;                               
        } else {
            socket = daemonPath;  
        }
        startService(new Intent(this, Overlay.class));
    }

    private void StopESP() {
        stopService(new Intent(this, Overlay.class));
    }

	public void loadAssets() {
        String filepath =Environment.getExternalStorageDirectory() + "/Android/data/.tyb";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filepath);
            byte[] buffer = "DO NOT DELETE".getBytes();
            fos.write(buffer, 0, buffer.length);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String pathf = getFilesDir().toString() + "/sock64";
        try {   
            OutputStream myOutput = new FileOutputStream(pathf);
            byte[] buffer = new byte[1024];
            int length;
            InputStream myInput = getAssets().open("sock64");
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myInput.close();
            myOutput.flush();
            myOutput.close();
        } catch (IOException e) { 
        }
        daemonPath = getFilesDir().toString() + "/sock64";
        try {
            Runtime.getRuntime().exec("chmod 777 " + daemonPath);
        } catch (IOException e) { 
        }
    }   


	
}
