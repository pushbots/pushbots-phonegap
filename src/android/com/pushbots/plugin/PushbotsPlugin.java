package com.pushbots.plugin;

import com.pushbots.push.Pushbots;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PushbotsPlugin extends CordovaPlugin {

	private static PushbotsPlugin instance;

	public PushbotsPlugin() {
		instance = this;
	}

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
		Pushbots.sharedInstance().init(cordova.getActivity());
	}

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext cb) throws JSONException {
		if (action.equals("setAlias")) {
			String alias;
			try {
				alias = args.getString(0);
				if (alias.equals("")) {
					alias = null;
				}
				Pushbots.sharedInstance().setAlias(cordova.getActivity().getApplication(), alias);
				cb.success("Alias Updated Successfully.");
			} catch (JSONException e) {
				cb.error("Error updating Alias.");
				e.printStackTrace();
				return false;
			}
		}else if (action.equals("Tag")) {
			String tag;
			try {
				tag = args.getString(0);
				if (tag.equals("")) {
					tag = null;
				}
				Pushbots.sharedInstance().tag(cordova.getActivity().getApplication(), tag, null);
				cb.success("Tag Updated Successfully.");
			} catch (JSONException e) {
				cb.error("Error updating tag.");
				e.printStackTrace();
				return false;
			}
		}else if (action.equals("delTag")) {
			String tag;
			try {
				tag = args.getString(0);
				if (tag.equals("")) {
					tag = null;
				}
				Pushbots.sharedInstance().untag(cordova.getActivity().getApplication(), tag, null);
				cb.success("Tag Updated Successfully.");
			} catch (JSONException e) {
				cb.error("Error updating tag.");
				e.printStackTrace();
				return false;
			}
		}else if (action.equals("isPushEnabled")){
			return Pushbots.sharedInstance().isPushEnabled();
		}
		return true;
	}
}
