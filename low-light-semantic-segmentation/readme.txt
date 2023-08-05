Requirements:
1. Compute resource with Nvidia CUDA core GPUs.
2. Internet Connection to download the test dataset from github
3. run.sh file will check and install required libraries - torch, segmentation-model-pytorch, albumentation, matplotlib and cv2

Files:
1. run.sh
	The shell script file run.sh will handle everything from downloading test dataset to setting 	up required libraries.
	Then it will execute the 3 models against the test data one by one in following order:
	--pspnet_resnet101_final.py
	--unet_resnet34_final.py
	--unet_resnet50_final.py



2.50466664_Final_Report.pdf
	The Project Report

3. The folders "pspnet_resnet101", "unet_resnet34", "unet_resnet50" and "deeplabv3plus_pretrained"
   contain the code for different models that were used for this project.
   All these folders contain the predicted masks of Night and Day images of custom dataset 
   in NightPred and DayPred folder