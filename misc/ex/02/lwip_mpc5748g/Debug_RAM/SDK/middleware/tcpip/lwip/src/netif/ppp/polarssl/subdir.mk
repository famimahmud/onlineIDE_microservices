################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/ppp/polarssl/arc4.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/ppp/polarssl/des.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/ppp/polarssl/md4.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/ppp/polarssl/md5.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/ppp/polarssl/sha1.c 

OBJS += \
./SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/arc4.o \
./SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/des.o \
./SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/md4.o \
./SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/md5.o \
./SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/sha1.o 

C_DEPS += \
./SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/arc4.d \
./SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/des.d \
./SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/md4.d \
./SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/md5.d \
./SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/sha1.d 


# Each subdirectory must supply rules for building sources it contributes
SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/arc4.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/ppp/polarssl/arc4.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/arc4.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/des.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/ppp/polarssl/des.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/des.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/md4.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/ppp/polarssl/md4.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/md4.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/md5.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/ppp/polarssl/md5.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/md5.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/sha1.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/ppp/polarssl/sha1.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/sha1.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


