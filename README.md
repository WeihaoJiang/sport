# sport

activity生命周期的调用

例子： A打开B（standard）再打开B（singletask） 再关闭B
备注： Flag的添加CLEAR_TOP和SINGLE_TOP，等同于singletask作用
                Intent intent = new Intent(this,DetailActivity1.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                
Log如下：
2021-03-05 14:29:36.114 27514-27514/com.example.jiangweihao.sport I/nft:  MainActivty onCreate 95139893
2021-03-05 14:29:36.158 27514-27514/com.example.jiangweihao.sport I/nft: MainActivity onStart  95139893
2021-03-05 14:29:36.159 27514-27514/com.example.jiangweihao.sport I/nft: MainActivity onresum   95139893

2021-03-05 14:29:43.253 27514-27514/com.example.jiangweihao.sport I/nft: MainActivity onPause   95139893
2021-03-05 14:29:43.321 27514-27514/com.example.jiangweihao.sport I/nft:  DetailActivity1 onCreate 31024227
2021-03-05 14:29:43.322 27514-27514/com.example.jiangweihao.sport I/nft:  DetailActivity1 onStart 31024227
2021-03-05 14:29:43.323 27514-27514/com.example.jiangweihao.sport I/nft:  DetailActivity1 onResume 31024227
2021-03-05 14:29:43.741 27514-27514/com.example.jiangweihao.sport I/nft: MainActivity onStop  95139893


2021-03-05 14:29:47.081 27514-27514/com.example.jiangweihao.sport I/nft:  DetailActivity1 onPause 31024227
2021-03-05 14:29:47.081 27514-27514/com.example.jiangweihao.sport I/nft:  DetailActivity1 onNewIntent 31024227
2021-03-05 14:29:47.082 27514-27514/com.example.jiangweihao.sport I/nft:  DetailActivity1 onResume 31024227


2021-03-05 14:29:54.339 27514-27514/com.example.jiangweihao.sport I/nft:  DetailActivity1 onPause 31024227
2021-03-05 14:29:54.352 27514-27514/com.example.jiangweihao.sport I/nft: MainActivity onRestart    95139893
2021-03-05 14:29:54.352 27514-27514/com.example.jiangweihao.sport I/nft: MainActivity onStart  95139893
2021-03-05 14:29:54.353 27514-27514/com.example.jiangweihao.sport I/nft: MainActivity onresum   95139893
2021-03-05 14:29:57.509 27514-27514/com.example.jiangweihao.sport I/nft:  DetailActivity1 onStop 31024227
2021-03-05 14:29:57.514 27514-27514/com.example.jiangweihao.sport I/nft:  DetailActivity1 onDestroy 31024227
