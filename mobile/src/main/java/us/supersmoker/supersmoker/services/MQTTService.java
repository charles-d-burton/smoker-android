package us.supersmoker.supersmoker.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MQTTService extends Service {
    private MqttAndroidClient client = null;


    public MQTTService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        if (intent != null) {

        } else {
            client = new MqttAndroidClient(this, "tcp://somker-relay.us:1883", MqttClient.generateClientId());
            client.setCallback(new MQTTListener());
            try {
                client.connect(null, new IMqttActionListener() {
                    @Override
                    public void onSuccess(IMqttToken iMqttToken) {

                    }

                    @Override
                    public void onFailure(IMqttToken iMqttToken, Throwable throwable) {

                    }
                });
            } catch (Exception e) {

            }
        }
        return Service.START_STICKY;
    }


    private class MQTTListener implements MqttCallback {

        @Override
        public void connectionLost(Throwable throwable) {

        }

        @Override
        public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

        }
    }
}
