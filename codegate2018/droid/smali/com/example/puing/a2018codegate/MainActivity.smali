.class public Lcom/example/puing/a2018codegate/MainActivity;
.super Landroid/support/v7/app/c;


# instance fields
.field l:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v7/app/c;-><init>()V

    return-void
.end method

.method public static k()Z
    .locals 2

    sget-object v0, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    const-string v1, "generic"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    const-string v1, "unknown"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    const-string v1, "sdk_google"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v1, "google_sdk"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v1, "Emulator"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v1, "Android SDK built for x86"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    const-string v1, "Genymotion"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->BRAND:Ljava/lang/String;

    const-string v1, "generic"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    const-string v1, "generic"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const-string v0, "google_sdk"

    sget-object v1, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3

    const v2, 0x7f080076

    invoke-super {p0, p1}, Landroid/support/v7/app/c;->onCreate(Landroid/os/Bundle;)V

    const v0, 0x7f0a001b

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/MainActivity;->setContentView(I)V

    const v0, 0x7f0800aa

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/Toolbar;

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/MainActivity;->a(Landroid/support/v7/widget/Toolbar;)V

    const v0, 0x7f080047

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    new-instance v1, Lcom/example/puing/a2018codegate/MainActivity$1;

    invoke-direct {v1, p0}, Lcom/example/puing/a2018codegate/MainActivity$1;-><init>(Lcom/example/puing/a2018codegate/MainActivity;)V

    invoke-virtual {v0, v1}, Landroid/support/design/widget/FloatingActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-static {}, Lcom/example/puing/a2018codegate/MainActivity;->k()Z

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    invoke-virtual {p0, v2}, Lcom/example/puing/a2018codegate/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const-string v1, "hi there"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_0
    const v0, 0x7f08003e

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/example/puing/a2018codegate/MainActivity;->l:Landroid/widget/EditText;

    iget-object v0, p0, Lcom/example/puing/a2018codegate/MainActivity;->l:Landroid/widget/EditText;

    const-string v1, "enter your id"

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    const v0, 0x7f080025

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    new-instance v1, Lcom/example/puing/a2018codegate/MainActivity$2;

    invoke-direct {v1, p0}, Lcom/example/puing/a2018codegate/MainActivity$2;-><init>(Lcom/example/puing/a2018codegate/MainActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void

    :cond_0
    invoke-virtual {p0, v2}, Lcom/example/puing/a2018codegate/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/example/puing/a2018codegate/MainActivity;->finishAffinity()V

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2

    invoke-virtual {p0}, Lcom/example/puing/a2018codegate/MainActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const/high16 v1, 0x7f0b0000

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    const/4 v0, 0x1

    return v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x7f080017

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/support/v7/app/c;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method
