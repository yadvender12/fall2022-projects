#!/bin/bash

git clone https://github.com/yadvender12/Custom_Dataset "./testdata/Custom_Dataset"
git clone https://github.com/yadvender12/Custom_Dataset_736_960 "./testdata/Custom_Dataset_736_960"

pip install segmentation-models-pytorch
pip install albumentations
pip install matplotlib
pip install torch
pip install cv2

python ./pspnet_resnet101/pspnet_resnet101_final.py

python ./unet_resnet34/unet_resnet34_final.py

python ./unet_resnet50/unet_resnet50_final.py