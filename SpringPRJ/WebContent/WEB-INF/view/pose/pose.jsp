<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <div style="display:none">Teachable Machine Pose Model</div>

    
    <div><canvas id="canvas"></canvas></div>
    <div id="label-container1">하이</div>
    
   
    <script src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs@1.3.1/dist/tf.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@teachablemachine/pose@0.8/dist/teachablemachine-pose.min.js"></script>
    <script type="text/javascript">
        // More API functions here:
        // https://github.com/googlecreativelab/teachablemachine-community/tree/master/libraries/pose
    
        // the link to your model provided by Teachable Machine export panel
        const URL = "./my_model/";
        let model, webcam, ctx, labelContainer, maxPredictions;
    
       //  async function init() {
    	   
    	    window.onload = async function(){
    	   
            const modelURL = URL + "model1.json";
            const metadataURL = URL + "metadata1.json";
    
            // load the model and metadata
            // Refer to tmImage.loadFromFiles() in the API to support files from a file picker
            // Note: the pose library adds a tmPose object to your window (window.tmPose)
            model = await tmPose.load(modelURL, metadataURL);
            maxPredictions = model.getTotalClasses();
    
            // Convenience function to setup a webcam
            const size = 500;
            const flip = true; // whether to flip the webcam
            webcam = new tmPose.Webcam(size, size, flip); // width, height, flip
            await webcam.setup(); // request access to the webcam
            await webcam.play();
            window.requestAnimationFrame(loop);
    
            // append/get elements to the DOM
            const canvas = document.getElementById("canvas");
            canvas.width = size; canvas.height = size;
            ctx = canvas.getContext("2d");

            labelContainer = document.getElementById("label-container1");
            labelContainer.appendChild(document.createElement("div"));     
        }
    
        async function loop(timestamp) {
            webcam.update(); // update the webcam frame
            await predict();
            window.requestAnimationFrame(loop);
        }
    
        var status = "stand"
        var count = 0;


        async function predict() {
            // Prediction #1: run input through posenet
            // estimatePose can take in an image, video or canvas html element
            const {pose, posenetOutput} = await model.estimatePose(webcam.canvas);
            // Prediction 2: run input through teachable machine classification model
            const prediction = await model.predict(posenetOutput);
            
            
            const classPrediction = count;
            labelContainer.childNodes[0].innerHTML = classPrediction;
    
            if(prediction[0].probability.toFixed(2) > 0.9){

                if(status == "down"){
                    count++;               
                }    
                
                status = "stand"
            }else if(prediction[1].probability.toFixed(2) == 1.00){

                status = "down"
            }
            
 
    
            // finally draw the poses
            drawPose(pose);
        }
    
        function drawPose(pose) {
            if (webcam.canvas) {
                ctx.drawImage(webcam.canvas, 0, 0);
                // draw the keypoints and skeleton
                if (pose) {
                    const minPartConfidence = 0.5;
                    tmPose.drawKeypoints(pose.keypoints, minPartConfidence, ctx);
                    tmPose.drawSkeleton(pose.keypoints, minPartConfidence, ctx);
                }
            }
        }
    </script>


</body>
</html>