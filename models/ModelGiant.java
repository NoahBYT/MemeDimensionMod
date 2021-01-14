
public static class ModelGiant extends ModelBase {
	ModelRenderer Head;
	ModelRenderer Body;
	ModelRenderer LeftArm;
	ModelRenderer RightArm;
	ModelRenderer RightLeg;
	ModelRenderer LeftLeg;

	public ModelGiant() {
		textureWidth = 384;
		textureHeight = 192;

		Head.mirror = true;
		Head = new ModelRenderer(this, 0, 0);
		Head.addBox(-4F, -8F, -4F, 48, 48, 48);
		Head.setRotationPoint(-20F, -160F, -8F);
		Head.setTextureSize(384, 192);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Head.mirror = false;
		Body.mirror = true;
		Body = new ModelRenderer(this, 96, 96);
		Body.addBox(-4F, 0F, -2F, 48, 72, 24);
		Body.setRotationPoint(-20F, -120F, 2F);
		Body.setTextureSize(384, 192);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		Body.mirror = false;
		LeftArm.mirror = true;
		LeftArm = new ModelRenderer(this, 240, 96);
		LeftArm.addBox(-1F, -2F, -2F, 24, 72, 24);
		LeftArm.setRotationPoint(25F, -118F, 22F);
		LeftArm.setTextureSize(384, 192);
		LeftArm.mirror = true;
		setRotation(LeftArm, -1.570796F, 0F, 0F);
		LeftArm.mirror = false;
		RightArm.mirror = true;
		RightArm = new ModelRenderer(this, 240, 96);
		RightArm.addBox(-3F, -2F, -2F, 24, 72, 24);
		RightArm.setRotationPoint(-45F, -118F, 22F);
		RightArm.setTextureSize(384, 192);
		RightArm.mirror = true;
		setRotation(RightArm, -1.570796F, 0F, 0F);
		RightArm.mirror = false;
		RightLeg.mirror = true;
		RightLeg = new ModelRenderer(this, 0, 96);
		RightLeg.addBox(-2F, 0F, -2F, 24, 72, 24);
		RightLeg.setRotationPoint(-22F, -48F, 2F);
		RightLeg.setTextureSize(384, 192);
		RightLeg.mirror = true;
		setRotation(RightLeg, 0F, 0F, 0F);
		RightLeg.mirror = false;
		LeftLeg.mirror = true;
		LeftLeg = new ModelRenderer(this, 0, 96);
		LeftLeg.addBox(-2F, 0F, -2F, 24, 72, 24);
		LeftLeg.setRotationPoint(2F, -48F, 2F);
		LeftLeg.setTextureSize(384, 192);
		LeftLeg.mirror = true;
		setRotation(LeftLeg, 0F, 0F, 0F);
		LeftLeg.mirror = false;
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Head.render(f5);
		Body.render(f5);
		LeftArm.render(f5);
		RightArm.render(f5);
		RightLeg.render(f5);
		LeftLeg.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}

}
