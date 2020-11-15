################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/autoip.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/dhcp.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/etharp.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/icmp.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/igmp.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/ip4.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/ip4_addr.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/ip4_frag.c 

OBJS += \
./SDK/middleware/tcpip/lwip/src/core/ipv4/autoip.o \
./SDK/middleware/tcpip/lwip/src/core/ipv4/dhcp.o \
./SDK/middleware/tcpip/lwip/src/core/ipv4/etharp.o \
./SDK/middleware/tcpip/lwip/src/core/ipv4/icmp.o \
./SDK/middleware/tcpip/lwip/src/core/ipv4/igmp.o \
./SDK/middleware/tcpip/lwip/src/core/ipv4/ip4.o \
./SDK/middleware/tcpip/lwip/src/core/ipv4/ip4_addr.o \
./SDK/middleware/tcpip/lwip/src/core/ipv4/ip4_frag.o 

C_DEPS += \
./SDK/middleware/tcpip/lwip/src/core/ipv4/autoip.d \
./SDK/middleware/tcpip/lwip/src/core/ipv4/dhcp.d \
./SDK/middleware/tcpip/lwip/src/core/ipv4/etharp.d \
./SDK/middleware/tcpip/lwip/src/core/ipv4/icmp.d \
./SDK/middleware/tcpip/lwip/src/core/ipv4/igmp.d \
./SDK/middleware/tcpip/lwip/src/core/ipv4/ip4.d \
./SDK/middleware/tcpip/lwip/src/core/ipv4/ip4_addr.d \
./SDK/middleware/tcpip/lwip/src/core/ipv4/ip4_frag.d 


# Each subdirectory must supply rules for building sources it contributes
SDK/middleware/tcpip/lwip/src/core/ipv4/autoip.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/autoip.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/core/ipv4/autoip.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/core/ipv4/dhcp.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/dhcp.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/core/ipv4/dhcp.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/core/ipv4/etharp.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/etharp.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/core/ipv4/etharp.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/core/ipv4/icmp.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/icmp.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/core/ipv4/icmp.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/core/ipv4/igmp.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/igmp.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/core/ipv4/igmp.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/core/ipv4/ip4.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/ip4.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/core/ipv4/ip4.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/core/ipv4/ip4_addr.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/ip4_addr.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/core/ipv4/ip4_addr.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/core/ipv4/ip4_frag.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/core/ipv4/ip4_frag.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/core/ipv4/ip4_frag.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


