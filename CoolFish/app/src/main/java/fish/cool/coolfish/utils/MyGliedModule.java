package fish.cool.coolfish.utils;

import android.content.Context;
import android.os.Environment;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Created by ch on 2017/11/27.
 */

public class MyGliedModule extends AppGlideModule{
    private int memoryCacheSize=5*1024*1024;
    private String cachePath= Environment.getExternalStorageDirectory()+"/Demo1/img";
    private int diskCacheSize=50*1024*1024;

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setMemoryCache(new LruResourceCache(memoryCacheSize))
                .setDiskCache(new InternalCacheDiskCacheFactory(context,diskCacheSize));
    }
}
